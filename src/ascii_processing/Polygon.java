package ascii_processing;

import java.util.ArrayList;

/** Abstract class for polygonal Shapes. */
public abstract class Polygon extends Shape {
    /**
     * Makes a border of lines from an array of points.
     * 
     * <p>Each segment has exactly one point for each x coordinate.
     * 
     * @see Shape#lineBetween(int[], int[])
     * 
     * @param vertices sequential vertices of the polygon
     * @return list of points of the border of the polygon
     */
    protected static ArrayList<int[]> makeBorder(int[][] vertices) {
        ArrayList<int[]> border = new ArrayList<int[]>();
        int[] prev = vertices[vertices.length - 1];
        for (int[] point : vertices) {
            border.addAll(Shape.lineBetween(prev, point));
            prev = point;
        }
        return border;
    }
    
    /**
     * Finds the points in a polygon from an array of vertices.
     * 
     * @see Shape#fillBorder(ArrayList)
     * 
     * @param vertices sequential vertices of the polygon
     */
    protected void makeShape(int[][] vertices) {
        ArrayList<int[]> border = Polygon.makeBorder(vertices);
        fillBorder(border);
    }
}
