import java.util.HashSet;

/** Shape base class. */
public abstract class Shape {
    /** Position of the shape.
     * 
     * @see #setPosition(int[])
     */
    public int[] pos;
    /** All points in the shape relative to its position. */
    public HashSet<int[]> points;

    /**
     * Modifies the Shape's position.
     * 
     * @param newPosition new position
     */
    public void setPosition(int[] newPosition) {
        this.pos = newPosition;
    }
}
