package ascii_processing;

import java.util.ArrayList;
import java.util.HashSet;

/** Abstract class for polygonal Shapes. */
public abstract class Polygon extends Shape {
    /**
     * Makes a border of lines from an array of points.
     * 
     * <p>Each segment has exactly one point for each x coordinate.
     * 
     * @see Utils#lineBetween(int[], int[])
     * 
     * @param vertices sequential vertices of the polygon
     * @return list of points of the border of the polygon
     */
    protected static ArrayList<int[]> makeBorder(int[][] vertices) {
        ArrayList<int[]> border = new ArrayList<int[]>();
        int[] prev = vertices[vertices.length - 1];
        for (int[] point : vertices) {
            border.addAll(Utils.lineBetween(prev, point));
            prev = point;
        }
        return border;
    }
    
    /**
     * Finds the points in a polygon from an array of vertices.
     * 
     * @see Utils#fillBorder(ArrayList)
     * 
     * @param vertices sequential vertices of the polygon
     * @return set of points in the polygon
     */
    protected static HashSet<int[]> makeShape(int[][] vertices) {
        ArrayList<int[]> border = Polygon.makeBorder(vertices);
        return Utils.fillBorder(border);
    }
}
