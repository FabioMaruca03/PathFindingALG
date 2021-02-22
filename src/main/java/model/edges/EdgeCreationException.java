package model.edges;

/**
 * Thrown when no edge parent is set.
 * @author fabiomaruca
 * @since 9-2-2021
 */
public class EdgeCreationException extends RuntimeException {
    public EdgeCreationException() {
        super("Unable to initialize the edge. Parent is null!");
    }
}
