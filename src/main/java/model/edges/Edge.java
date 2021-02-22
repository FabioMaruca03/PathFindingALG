package model.edges;

/**
 * Describes a basic graph edge
 * @author fabiomaruca
 * @since 9-2-2021
 */
public interface Edge {

    /**
     * Should destroy the relationship between two {@link model.nodes.AbstractNode}. <br/>
     * It removes the link from the parent <br/>
     * Then should make each field null allowing the gc to finalize the object
     * @since 9-2-2021
     */
    void breakRelationship();

    /**
     * It should create two links: <br/>
     * Parent -> Child & Child -> Parent. <br/>
     * If the link already exists, does nothing.
     * @since 9-2-2021
     */
    void bindBidirectionally();

    /**
     * Establishes if each node is linked according to the internal {@link model.nodes.AbstractNode} bind rules.
     * @return TRUE if the each node is linked else FALSE
     * @since 9-2-2021
     */
    boolean isJoined();

}
