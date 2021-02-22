package model.edges;

/**
 * Thrown if the edge is not properly set
 * @author fabiomaruca
 * @since 9-2-2021
 */
public class EdgeOrientationException extends RuntimeException{
    public EdgeOrientationException(String message) {
        super("Unable to bind nodes. The relationship is directional: " + message);
    }
}
