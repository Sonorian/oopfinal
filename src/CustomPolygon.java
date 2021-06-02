import java.util.ArrayList;

public class CustomPolygon extends Polygon {
    public CustomPolygon(int[][] vertices) {
        this.pos = vertices[0];
        int[][] relativeVertices = new int[vertices.length][2];
        for (int i = 0; i < vertices.length; i++) {
            int [] vertex = vertices[i];
            relativeVertices[i] = new int[] {vertex[0] - this.pos[0], vertex[1] - pos[1]};
        }
        ArrayList<int[]> border = Polygon.makeBorder(relativeVertices);
        this.points = Utils.fillBorder(border);
    }
}
