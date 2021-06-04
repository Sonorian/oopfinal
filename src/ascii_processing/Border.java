package ascii_processing;

/** 
 * A CompositeShape consisting of the edges of the plane.
 * 
 * @see Line
 * @see Display#width
 * @see Display#height
 */
public class Border extends CompositeShape {
    /** Makes a Border. */
    public Border() {
        Display display = Display.getDisplay();
        int[] cornerBL = new int[] {0, 0};
        int[] cornerTL = new int[] {0, display.height - 1};
        int[] cornerTR = new int[] {display.width - 1, display.height - 1};
        int[] cornerBR = new int[] {display.width - 1, 0};
        Shape[] border = new Shape[]
            {new Line(cornerBL, cornerTL),
             new Line(cornerTL, cornerTR),
             new Line(cornerTR, cornerBR),
             new Line(cornerBR, cornerBL)};
        this.pos = cornerBL;
        this.points = new RelativePoints(2*display.width + 2*display.height - 4);
        for (Shape line : border) {
            addShape(line);
        }
    }
}
