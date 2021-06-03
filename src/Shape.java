import java.util.HashSet;

/** Shape base class. */
public abstract class Shape {
    /** x,y position of the shape. */
    int[] pos;
    /** Set of all points in the shape relative to its position. */
    HashSet<int[]> points;

    public void setPosition(int[] newPosition) {
        this.pos = newPosition;
    }
}
