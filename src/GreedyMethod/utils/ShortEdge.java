package GreedyMethod.utils;

public class ShortEdge {
    private int lowcost;
    private int adjvex;

    public ShortEdge() {
    }

    public ShortEdge(int lowcost, int adjvex) {
        this.lowcost = lowcost;
        this.adjvex = adjvex;
    }

    public int getLowcost() {
        return lowcost;
    }

    public void setLowcost(int lowcost) {
        this.lowcost = lowcost;
    }

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }
}
