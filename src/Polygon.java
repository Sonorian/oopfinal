import java.util.ArrayList;
import java.util.Arrays;

public abstract class Polygon extends Shape {
    public static int[][] makeBorder(int[][] vertices) {
        ArrayList<int[]> border = new ArrayList<int[]>(vertices.length);
        int[] prev = vertices[vertices.length-1];
        for (int[] point : vertices) {
            border.addAll(Arrays.asList(Utils.lineBetween(prev, point)));
            prev = point;
        }
        System.out.println("In Polygon:");
        return border.toArray(vertices);
    }
}
