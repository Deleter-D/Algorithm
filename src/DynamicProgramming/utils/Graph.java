package DynamicProgramming.utils;

import java.util.Arrays;

public class Graph {
    private int vnum, arcnum;
    private int[][] matrix;

    public Graph() {
    }

    public Graph(int vnum, int arcnum, int[][] matrix) {
        this.vnum = vnum;
        this.arcnum = arcnum;
        this.matrix = matrix;
    }

    public int getVnum() {
        return vnum;
    }

    public void setVnum(int vnum) {
        this.vnum = vnum;
    }

    public int getArcnum() {
        return arcnum;
    }

    public void setArcnum(int arcnum) {
        this.arcnum = arcnum;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vnum=" + vnum +
                ", arcnum=" + arcnum +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
