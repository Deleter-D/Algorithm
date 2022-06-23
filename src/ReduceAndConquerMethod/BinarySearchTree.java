package ReduceAndConquerMethod;

import ReduceAndConquerMethod.utils.BinaryTree;

public class BinarySearchTree {
    public static BinaryTree InsertBST(BinaryTree root, int data) {
        if (root == null) {
            root = new BinaryTree();
            root.setData(data);
            root.setLchild(null);
            root.setRchild(null);
            return root;
        }
        if (data <= root.getData()) {
            root.setLchild(InsertBST(root.getLchild(), data));
        } else {
            root.setRchild(InsertBST(root.getRchild(), data));
        }
        return root;
    }

    public static BinaryTree CreateBST(int[] A) {
        BinaryTree T = new BinaryTree();
        for (int i = 0; i < A.length; i++) {
            T = InsertBST(T, A[i]);
        }
        return T;
    }

    public static BinaryTree SearchBST(BinaryTree root, int key) {
        if (root == null) return null;
        else if (root.getData() == key) return root;
        else if (key < root.getData()) return SearchBST(root.getLchild(), key);
        else return SearchBST(root.getRchild(), key);
    }

    public static void main(String[] args) {
        int[] r = {1, 3, 4, 6, 8, 9, 13};
        BinaryTree T = CreateBST(r);
        System.out.println(SearchBST(T, 5));
    }
}
