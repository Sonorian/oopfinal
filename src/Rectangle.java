public class Rectangle extends Shape {
    protected Rectangle() {}
    public Rectangle(int[] position, int width, int height) {
        this.pos = position;
        this.points = Polygon.makeShape(Rectangle.makeVertices(width, height));
    }

    protected static int[][] makeVertices(int width, int height) {
        int[][] vertices = new int[][]
            {{0, 0}, {0, height}, {width, height}, {width, 0}};
        return vertices;
    }
}
