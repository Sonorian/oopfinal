package ascii_processing;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

/** 
 * Shape base class.
 * 
 * <p>Also contains classes and methods used for constructing shapes. 
 */
public abstract class Shape {
    /** Position of the shape.
     * 
     * @see #setPosition(int[])
     */
    public int[] pos;
    /** All points in the shape relative to its position. */
    public RelativePoints points;

    /**
     * Modifies the Shape's position.
     * 
     * @param newPosition new position
     */
    public void setPosition(int[] newPosition) {
        this.pos = newPosition;
    }

    /** 
     * A Shape's x,y points. 
     * 
     * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html">java.util.HashSet&lt;E&gt;</a>
     */
    protected class RelativePoints extends HashSet<int[]> {
        /** 
         * Makes an empty RelativePoints.
         * 
         * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html#%3Cinit%3E()">java.util.HashSet&lt;E&gt;#init();</a>
         */
        public RelativePoints() {
            super();
        }

        /** 
         * Makes an empty RelativePoints with a specified initial capacity. 
         * 
         * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html#%3Cinit%3E(int)">java.util.HashSet&lt;E&gt;#init(int);</a>
         * 
         * @param initialCapacity the initial capacity of the hash table
         */
        public RelativePoints(int initialCapacity) {
            super(initialCapacity);
        }

        /** 
         * Makes an empty RelativePoints with a specified initial capacity and load factor.
         * 
         * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html#%3Cinit%3E(int,float)">java.util.HashSet&lt;E&gt;#init(int, float);</a>
         * 
         * @param initialCapacity the initial capacity of the hash table
         * @param loadFactor something that determines when the capacity of the set doubles
         */
        public RelativePoints(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }
        
        /** 
         * Makes a RelativePoints that extends another Collection.
         * 
         * @see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html#%3Cinit%3E(java.util.Collection)">java.util.HashSet&lt;E&gt;#init(Collection&lt;? extends E&gt;);</a>
         * 
         * @param c the collection to convert into a RelativePoints
         */
        public RelativePoints(Collection<int[]> c) {
            super(c);
        }

        /**
         * Reverses its points. 
         * 
         * @see Shape#reversePoint(int[])
         */
        protected final void reversePoints() {
            HashSet<int[]> newPoints = new HashSet<int[]>(this.size());
            for (int[] point : this) {
                newPoints.add(Shape.reversePoint(point));
            }
            this.clear();
            this.addAll(newPoints);
        }
    
        /**
         * Prints each point within, separated by newlines.
         * 
         * <p>Used for debugging. 
         */
        public final void printPoints() {
            for (int[] point : this) {
                System.out.println(Arrays.toString(point));
            }
        }
    }

    /**
     * Makes a line between 2 points.
     * 
     * <p>Has exactly one point for every x coordinate. 
     * Does not include the ending point. 
     * 
     * @see #straightLine(int[], int[])
     * 
     * @param point1 starting point
     * @param point2 ending point
     * @return the line between the points
     */
    protected static final ArrayList<int[]> lineBetween(int[] point1, int[] point2) {
        int x0 = point1[0];
        int y0 = point1[1];
        int xRange = point2[0] - x0;
        int yRange = point2[1] - y0;
        ArrayList<int[]> line = new ArrayList<int[]>(Math.abs(xRange));
        if (xRange == 0) {
            // Returns just point1 if the line is vertical.
            xRange = 1;
        }
        float slope = (float) yRange/xRange;
        int sign = xRange/Math.abs(xRange);
        for (int i=0; i<Math.abs(xRange); i++) {
            int x = x0 + i*sign;
            float y = y0 + i*sign*slope;
            int[] point = new int[] {Math.round(x), Math.round(y)};
            line.add(point);
        }
        return line;
    }

    /**
     * Returns an ArrayList of the points on a vertical line.
     * 
     * @see #lineBetween(int[], int[])
     * 
     * @param point1 starting point
     * @param point2 point with y coordinate to end by
     * @return list of points on the vertical line
     */
    protected static final ArrayList<int[]> straightLine(int[] point1, int[] point2) {
        int start = Math.min(point1[1], point2[1]);
        int end = Math.max(point1[1], point2[1]);
        ArrayList<int[]> line = new ArrayList<int[]>(end-start);
        for (int i = start; i < end; i++) {
            line.add(new int[] {point1[0], start + i});
        }
        return line;
    }

    /**
     * Makes a point with reversed coordinates.
     * 
     * <p>For example, (x,y) becomes (y,x). 
     * 
     * @see RelativePoints#reversePoints()
     * 
     * @param point 2D point
     * @return reversed point
     */
    protected static final int[] reversePoint(int[] point) {
        return new int[] {point[1], point[0]};
    }

    /**
     * Duplicates some vertices of a border.
     * 
     * <p>The duplicated vertices are adjacent to two points with the same x coordinate.
     * Required for {@link #fillBorder(ArrayList)} to work properly for more complex shapes. 
     * 
     * @param border list of points on a border
     * @return border with duplicated vertices
     */
    private static final ArrayList<int[]> duplicateVertices(ArrayList<int[]> border) {
        ArrayList<int[]> borderFixed = new ArrayList<int[]>(border.size());
        int[] previous = border.get(border.size() - 2);
        int[] analyzing = border.get(border.size() - 1);
        for(int[] next : border) {
            borderFixed.add(analyzing);
            if (previous[0] == next[0]) {
                borderFixed.add(analyzing);
            }
            previous = analyzing;
            analyzing = next;
        }
        return borderFixed;
    }

    /**
     * Finds all points within a border.
     * 
     * <p>The border must be ordered sequentially. 
     * 
     * @see Polygon#makeBorder(int[][])
     * 
     * @param border list of points on a border
     */
    protected final void fillBorder(ArrayList<int[]> border) {
        ArrayList<int[]> borderFixed = Shape.duplicateVertices(border);
        RelativePoints fillPoints = new RelativePoints(borderFixed);
        HashMap<Integer,int[]> unmatchedPoints = new HashMap<Integer,int[]>();
        for (int[] point : borderFixed) {
            int x = point[0];
            if (unmatchedPoints.containsKey(x)) {
                fillPoints.addAll(Shape.straightLine(point, unmatchedPoints.get(x)));
                unmatchedPoints.remove(x);
            }
            else {
                unmatchedPoints.put(x, point);
            }
        }
        this.points = fillPoints;
    }
}
