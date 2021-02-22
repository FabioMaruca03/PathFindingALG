package model.edges;

import model.nodes.AbstractNode;

/**
 * Represents a non weighted edge.
 * @author fabiomaruca
 * @since 9-2-2021
 */
public class NonWeightedEdge implements Edge {
    protected AbstractNode<NonWeightedEdge> parent;
    protected AbstractNode<NonWeightedEdge> child;
    protected final boolean bidirectional;

    /**
     * Initializes a new Edge between two {@link AbstractNode}s
     * @param parent The edge owner
     * @param child The edge slave
     * @param bidirectional Set true to create a bidirectional edge
     * @since 9-2-2021
     */
    public NonWeightedEdge(AbstractNode<NonWeightedEdge> parent, AbstractNode<NonWeightedEdge> child, boolean bidirectional) {
        if (parent == null)
            throw new EdgeCreationException();
        this.bidirectional = bidirectional;
        setParent(parent);
        setChild(child);
    }

    /**
     * @return The {@link NonWeightedEdge} parent
     * @since 9-2-2021
     */
    public AbstractNode<NonWeightedEdge> getParent() {
        return parent;
    }

    /**
     * It changes the edge parent. It also updates the {@link AbstractNode}'s edges list,
     * it removes the old parent's link (if any) from its edges list.
     * @param parent The edge parent
     * @since 9-2-2021
     */
    public void setParent(AbstractNode<NonWeightedEdge> parent) {
        if (this.parent != null)
            this.parent.getEdges().removeIf(it->it.equals(this));
        if (parent!= null) {
            this.parent = parent;
            if (!parent.getEdges().contains(this)) {
                this.parent.getEdges().add(this);
            }
        }
    }

    /**
     * @return The {@link NonWeightedEdge} child
     * @since 9-2-2021
     */
    public AbstractNode<NonWeightedEdge> getChild() {
        return child;
    }

    /**
     * It changes the edge child. It also updates the {@link AbstractNode}'s edges list,
     * if the edge is bidirectional, it updates the old child edges list (if any).
     * @param child The edge child
     * @since 9-2-2021
     */
    public void setChild(AbstractNode<NonWeightedEdge> child) {
        if (bidirectional && this.child != null)
            this.child.getEdges().removeIf(it->it.equals(this));
        if (child!= null) {
            this.child = child;
            if (bidirectional && !child.getEdges().contains(this)) {
                this.child.getEdges().add(this);
            }
        }
    }

    /**
     * @return True if the {@link NonWeightedEdge} is bidirectional else returns false.
     * @since 9-2-2021
     */
    public boolean isBidirectional() {
        return bidirectional;
    }

    @Override
    public void bindBidirectionally() {
        if (bidirectional) {
            if (!child.getEdges().contains(this)) {
                child.getEdges().add(this);
            }
        } else throw new EdgeOrientationException(parent.getId().concat(" -> ").concat(child.getId()));
    }

    @Override
    public void breakRelationship() {
        if (bidirectional)
            child.getEdges().removeIf(it->it.equals(this));
        parent.getEdges().removeIf(it->it.equals(this));
        parent = null;
        child = null;
    }

    @Override
    public boolean isJoined() {
        return false;
    }

}
