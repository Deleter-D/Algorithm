package DivideAndConquerMethod;

import java.util.Arrays;

public class BoardCoverProblem {

    private static int t;

    /**
     * @param board 棋盘
     * @param tr    棋盘左上角的行标
     * @param tc    棋盘左上角的列标
     * @param dr    特殊方块的行标
     * @param dc    特殊方块的列标
     * @param size  棋盘的阶数
     * @return 骨牌放置的结果
     */
    public static int[][] ChessBoard(int[][] board, int tr, int tc, int dr, int dc, int size) {
        int s, t1;// t1表示本次覆盖使用的L型骨牌编号
        if (size == 1)
            return board;
        t1 = ++t;
        s = size / 2;// 划分
        // 处理左上角子棋盘
        if (dr < tr + s && dc < tc + s) {// 若特殊方格在左上角的子棋盘中
            board = ChessBoard(board, tr, tc, dr, dc, s);// 递归处理
        } else {// 否则用t1号骨牌覆盖右下角，再递归处理子棋盘
            board[tr + s - 1][tc + s - 1] = t1;
            board = ChessBoard(board, tr, tc, tr + s - 1, tc + s - 1, s);
        }
        // 处理右上角子棋盘
        if (dr < tr + s && dc >= tc + s) {// 若特殊方格在右上角的子棋盘中
            board = ChessBoard(board, tr, tc + s, dr, dc, s);// 递归处理
        } else {// 否则用t1号骨牌覆盖左下角，再递归处理子棋盘
            board[tr + s - 1][tc + s] = t1;
            board = ChessBoard(board, tr, tc + s, tr + s - 1, tc + s, s);
        }
        // 处理左下角子棋盘
        if (dr >= tr + s && dc < tc + s) {// 若特殊方格在左下角的子棋盘中
            board = ChessBoard(board, tr + s, tc, dr, dc, s);// 递归处理
        } else {// 否则用t1号骨牌覆盖右上角，再递归处理子棋盘
            board[tr + s][tc + s - 1] = t1;
            board = ChessBoard(board, tr + s, tc, tr + s, tc + s - 1, s);
        }
        // 处理右下角子棋盘
        if (dr >= tr + s && dc >= tc + s) {// 若特殊方格在右下角的子棋盘中
            board = ChessBoard(board, tr + s, tc + s, dr, dc, s);// 递归处理
        } else {// 否则用t1号骨牌覆盖左上角，再递归处理子棋盘
            board[tr + s][tc + s] = t1;
            board = ChessBoard(board, tr + s, tc + s, tr + s, tc + s, s);
        }
        return board;
    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        t = 0;
        int[][] result = ChessBoard(board, 0, 0, 3, 1, 8);
        for (int[] item : result) {
            for (int i : item) {
                if (i < 10) {
                    System.out.print("0");
                }
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
