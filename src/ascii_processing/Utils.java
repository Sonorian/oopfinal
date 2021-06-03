package ascii_processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Class with useful random methods. 
 * 
 * <p>Note to self: 
 * <br>Maybe make into an interface with default methods? 
 * <br>Maybe move methods to {@link Shape} and make protected? 
 * I mean shapes are the only ones that use them atm 
 * (except for printPoints, but that can be worked around, 
 * and nothing uses it anymore, anyways.) 
 */
public abstract class Utils {
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
    public static final ArrayList<int[]> lineBetween(int[] point1, int[] point2) {
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
    public static final ArrayList<int[]> straightLine(int[] point1, int[] point2) {
        int start = Math.min(point1[1], point2[1]);
        int end = Math.max(point1[1], point2[1]);
        ArrayList<int[]> line = new ArrayList<int[]>(end-start);
        for (int i = start; i < end; i++) {
            line.add(new int[] {point1[0], start + i});
        }
        return line;
    }

    /**
     * Reverses a point's coordinates.
     * 
     * <p>For example, (x,y) becomes (y,x). 
     * 
     * @see #reversePoints(HashSet)
     * 
     * @param point 2D point
     * @return reversed point
     */
    public static final int[] reversePoint(int[] point) {
        return new int[] {point[1], point[0]};
    }

    /**
     * Reverses the points of a HashSet.
     * 
     * @see #reversePoint(int[])
     * 
     * @param points set of points
     * @return set of reversed points
     */
    public static final HashSet<int[]> reversePoints(HashSet<int[]> points) {
        HashSet<int[]> outSet = new HashSet<int[]>(points);
        for (int[] point : points) {
            outSet.add(Utils.reversePoint(point));
        }
        return outSet;
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
     * @return set of points within and including the border
     */
    public static final HashSet<int[]> fillBorder(ArrayList<int[]> border) {
        ArrayList<int[]> borderFixed = Utils.duplicateVertices(border);
        HashSet<int[]> fillPoints = new HashSet<int[]>(borderFixed);
        HashMap<Integer,int[]> unmatchedPoints = new HashMap<Integer,int[]>();
        for (int[] point : borderFixed) {
            int x = point[0];
            if (unmatchedPoints.containsKey(x)) {
                fillPoints.addAll(Utils.straightLine(point, unmatchedPoints.get(x)));
                unmatchedPoints.remove(x);
            }
            else {
                unmatchedPoints.put(x, point);
            }
        }
        return fillPoints;
    }

    /**
     * Prints each point in a set, separated by newlines.
     * 
     * <p>Used for debugging. 
     * 
     * @param points points to print
     */
    public static final void printPoints(HashSet<int[]> points) {
        for (int[] point  : points) {
            System.out.println(Arrays.toString(point));
        }
    }
}
