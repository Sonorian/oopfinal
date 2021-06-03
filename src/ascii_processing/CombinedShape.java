import java.util.HashSet;

/** A Shape consisting of multiple other Shapes. */
public class CombinedShape extends Shape{
    /** Empty constructor so child classes work. */
    protected CombinedShape() {}

    /** Makes a CombinedShape. 
     * 
     * @param components {@link Shape}s that comprise this shape
     */
    public CombinedShape(Shape[] components) {
        this.pos = components[0].pos;
        this.points = new HashSet<int[]>();
        for (Shape shape : components) {
            addShape(shape);
        }
    }

    /**
     * Adds the points of another shape to this shape.
     * 
     * <p>All added points are relative to this shape's position.
     * 
     * @param shape {@link Shape} to be added
     */
    public final void addShape(Shape shape) {
        int relativeX = shape.pos[0] - this.pos[0];
            int relativeY = shape.pos[1] - this.pos[1];
            for (int[] point : shape.points) {
                this.points.add(new int[]
                    {relativeX + point[0], relativeY + point[1]});
            }
    }

    /**
     * Removes the points of another shape from this shape. 
     * 
     * @param shape {@link Shape} to remove
     */
    public final void removeShape(Shape shape) {
        int relativeX = shape.pos[0] - this.pos[0];
            int relativeY = shape.pos[1] - this.pos[1];
            for (int[] point : shape.points) {
                this.points.remove(new int[]
                    {relativeX + point[0], relativeY + point[1]});
            }
    }
}
