package ascii_processing;

/** A Polygon that's a rectangle */
public class Rectangle extends Polygon {
    /** Empty constructor so child classes work. */
    protected Rectangle() {}

    /**
     * Makes a Rectangle. 
     * 
     * @param position x,y position of the bottom left corner
     * @param width width of the rectangle
     * @param height height of the rectangle
     */
    public Rectangle(int[] position, int width, int height) {
        this.pos = position;
        this.points = Polygon.makeShape(Rectangle.makeVertices(width, height));
    }

    /**
     * Finds the relative vertices of a rectangle.
     * 
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @return vertices of the rectangle
     */
    protected static int[][] makeVertices(int width, int height) {
        int[][] vertices = new int[][]
            {{0, 0}, {0, height}, {width, height}, {width, 0}};
        return vertices;
    }
}
