public class Square extends Polygon {

    public Square(int[] pos, int side) {
        this.x = pos[0];
        this.y = pos[1];
        int[][] vertices = new int[][] {{0,0},{0,side},{side,side},{side,0}};
        int[][] border = Polygon.makeBorder(vertices);
        //this.points = border;
        this.points = Utils.fillBorder(border);
        Utils.printPoints(this.points);
    }
}
