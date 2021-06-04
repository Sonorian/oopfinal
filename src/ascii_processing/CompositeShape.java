package ascii_processing;

/** A Shape consisting of multiple other Shapes. */
public class CompositeShape extends Shape{
    /** Empty constructor so child classes work. */
    protected CompositeShape() {}

    /** Makes a CompositeShape. 
     * 
     * @param components {@link Shape}s that comprise this shape
     */
    public CompositeShape(Shape[] components) {
        this.pos = components[0].pos;
        this.points = new RelativePoints();
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

    /**
     * Removes the points of this shape that aren't part of another shape. 
     * 
     * @param shape {@link Shape} to intersect this shape with
     */
    public final void intersectShape(Shape shape) {
        int relativeX = this.pos[0] - shape.pos[0]; // relative to shape's position,
        int relativeY = this.pos[1] - shape.pos[1]; // unlike all other methods
            for (int[] point : this.points) {
                int[] relativePoint = new int[]
                    {relativeX + point[0], relativeY + point[1]};
                if (shape.points.contains(relativePoint) == false) {
                    this.points.remove(point);
                }
            }
    }

    /**
     * Combines this shape with another, excluding points shared by both. 
     * 
     * @param shape {@link Shape} to combine this shape with
     */
    public final void reverseIntersectShape(Shape shape) {
        int relativeX = shape.pos[0] - this.pos[0];
        int relativeY = shape.pos[1] - this.pos[1];
            for (int[] point : shape.points) {
                int[] relativePoint = new int[]
                    {relativeX + point[0], relativeY + point[1]};
                if (this.points.contains(relativePoint) == false) {
                    this.points.add(relativePoint);
                } else {
                    this.points.remove(relativePoint);
                }
            }
    }
}
