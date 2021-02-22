package model.nodes;

import model.edges.Edge;

import java.util.PriorityQueue;

public abstract class AbstractNode<E extends Edge> {
    protected double x, y;
    protected PriorityQueue<E> edges;
    protected String id;

    public PriorityQueue<E> getEdges() {
        return edges;
    }

    public String getId() {
        return id;
    }
}
