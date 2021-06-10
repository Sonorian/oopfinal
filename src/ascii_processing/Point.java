package ascii_processing;

/** A Shape consisting of a single point. */
public class Point extends Shape{
    /** Makes a Point.
     * 
     * @param position position of the point
     */
    Point(int[] position) {
        this.pos = position;
        this.points = new RelativePoints(1);
        this.points.add(new int[] {0, 0});
    }
}
