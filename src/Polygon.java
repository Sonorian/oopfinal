import java.util.ArrayList;

public abstract class Polygon extends Shape {
    public static ArrayList<int[]> makeBorder(int[][] vertices) {
        ArrayList<int[]> border = new ArrayList<int[]>(vertices.length);
        int[] prev = vertices[vertices.length - 1];
        for (int[] point : vertices) {
            border.addAll(Utils.lineBetween(prev, point));
            prev = point;
        }
        return border;
    }
}
