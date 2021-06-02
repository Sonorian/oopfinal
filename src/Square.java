import java.util.ArrayList;

public class Square extends Polygon {

    public Square(int[] position, int side) {
        this.pos = position;
        int[][] vertices = new int[][] {{0,0},{0,side},{side,side},{side,0}};
        ArrayList<int[]> border = Polygon.makeBorder(vertices);
        //this.points = border;
        this.points = Utils.fillBorder(border);
    }
}
