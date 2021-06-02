import java.util.ArrayList;
import java.util.HashSet;

public abstract class Polygon extends Shape {
    protected static ArrayList<int[]> makeBorder(int[][] vertices) {
        ArrayList<int[]> border = new ArrayList<int[]>();
        int[] prev = vertices[vertices.length - 1];
        for (int[] point : vertices) {
            border.addAll(Utils.lineBetween(prev, point));
            prev = point;
        }
        System.out.println("Polygon:");
        Utils.printPoints(new HashSet<int[]>(border));
        return border;
    }
}
