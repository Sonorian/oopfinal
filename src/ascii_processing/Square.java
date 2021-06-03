package ascii_processing;

/** A Rectangle with equal height and width. */
public class Square extends Rectangle {
    /**
     * Makes a Square.
     * 
     * @param position x,y position of the bottom left corner of the square
     * @param side side length of the square
     */
    public Square(int[] position, int side) {
        this.pos = position;
        this.points = Polygon.makeShape(Rectangle.makeVertices(side, side));
    }
}
