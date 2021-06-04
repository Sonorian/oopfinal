package ascii_processing;

/** A Shape that kinda looks like a circle. */
public class Circle extends Shape {
    /**
     * Makes a Circle.
     * 
     * @param position x,y coordinate of the center of the circle
     * @param radius radius of the circle + 0.5
     */
    public Circle(int[] position, int radius) {
        this.pos = position;
        this.points = new RelativePoints();
        makeShape(radius);
    }

    /**
     * Returns the set of all points in a circle of a specified radius (kind of).
     * 
     * <p>Checks all points from (0,0) to (radius-1, radius-1). 
     * If x^2 + y^2 &lt;= radius^2 it adds that point in each quadrant. 
     * This results in a circle with a diameter of 2*radius-1, 
     * which means the circle's radius != radius. // &lt;-- fix this //
     * 
     * @param radius radius of the circle + 0.5
     */
    protected final void makeShape(int radius) {
        for (int y = 0; y < radius; y++) {
            for (int x = 0; x < radius; x++) {
                if (x*x + y*y <= radius*radius) {
                    this.points.add(new int[] {x, y});
                    this.points.add(new int[] {-x, y});
                    this.points.add(new int[] {-x, -y});
                    this.points.add(new int[] {x, -y});
                }
            }
        }
    }
}
