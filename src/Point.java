import java.util.HashSet;

/** A Shape consisting of a single point. */
public class Point extends Shape{
    /** Makes a Point.
     * 
     * @param position position of the point
     */
    Point(int[] position) {
        this.pos = position;
        this.points = new HashSet<int[]>(1);
        this.points.add(new int[] {0, 0});
    }
}
