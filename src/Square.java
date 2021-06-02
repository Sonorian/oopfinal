public class Square extends Rectangle {
    public Square(int[] position, int side) {
        this.pos = position;
        this.points = Polygon.makeShape(Rectangle.makeVertices(side, side));
    }
}
