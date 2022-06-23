package ReduceAndConquerMethod.utils;

public class BinaryTree {
    private int data;
    private BinaryTree lchild, rchild;

    public BinaryTree() {
    }

    public BinaryTree(int data, BinaryTree lchild, BinaryTree rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTree getLchild() {
        return lchild;
    }

    public void setLchild(BinaryTree lchild) {
        this.lchild = lchild;
    }

    public BinaryTree getRchild() {
        return rchild;
    }

    public void setRchild(BinaryTree rchild) {
        this.rchild = rchild;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "data=" + data +
                ", lchild=" + lchild +
                ", rchild=" + rchild +
                '}';
    }
}
