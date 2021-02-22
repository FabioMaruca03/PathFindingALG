package model.edges;

import model.nodes.AbstractNode;

public class WeighedEdge <W extends Comparable<W>> extends NonWeightedEdge {
    protected W weight;

    public WeighedEdge(AbstractNode<NonWeightedEdge> parent, AbstractNode<NonWeightedEdge> child, boolean bidirectional) {
        super(parent, child, bidirectional);
    }

    /**
     * Given another {@link WeighedEdge} with the same Weight, returns the best comparing weights
     * @param other The other {@link WeighedEdge}
     * @return The {@link WeighedEdge} with the lowest assigned weight
     * @since 9-2-2021
     */
    public WeighedEdge<W> pickBest(WeighedEdge<W> other) {
        return weight.compareTo(other.weight) <= 0?this:other;
    }

    /**
     * Gets the weight of the edge.
     * @return The edge weight
     * @since 9-2-2021
     */
    public W getWeight() {
        return weight;
    }

    public void setWeight(W weight) {
        this.weight = weight;
    }
}
