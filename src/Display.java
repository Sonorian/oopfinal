/**
 * Singleton class for the contents of the screen.
 * 
 * <p>Everything that changes what is displayed is a method of this class.
 */
public class Display {
    public char[][] plane;
    public char fill;
    public int width;
    public int height;
    private static final Display displayInstance = new Display();

    /** Makes the Display. */
    private Display() {
        this.width = 100;
        this.height = 14;
        this.plane = new char[this.height][this.width];
        this.fill = ' ';
    }

    /** Returns the Display instance. */
    public static final Display getDisplay() {
        return Display.displayInstance;
    }

    /** Returns a CombinedShape consisting of the edges of the plane */
    public final CombinedShape getBorder() {
        int[] cornerBL = new int[]
            {0, 0};
        int[] cornerTL = new int[]
            {0, Display.displayInstance.height - 1};
        int[] cornerTR = new int[]
            {Display.displayInstance.width - 1, Display.displayInstance.height - 1};
        int[] cornerBR = new int[]
            {Display.displayInstance.width - 1, 0};
        Shape[] border = new Shape[]
            {new Line(cornerBL, cornerTL),
             new Line(cornerTL, cornerTR),
             new Line(cornerTR, cornerBR),
             new Line(cornerBR, cornerBL)};
        return new CombinedShape(border);
    }

    /** Modifies the width and height of the plane, and clears it. */
    public final void setDimensions(int width, int height) {
        this.plane = new char[height][width];
        this.width = width;
        this.height = height;
    }

    public final void setFill(char fillCharacter) {
        this.fill = fillCharacter;
    }

    /**
     * Changes one cell of the plane to the fill character.
     * 
     * @param point x,y point to change
     */
    public final void setCell(int[] point) {
        try {
            this.plane[point[1]][point[0]] = this.fill;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    /** Sets all points of the plane to the fill character. */
    public final void setBackground() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.setCell(new int[] {x, y});
            }
        }
    }

    /** Sets a Shape to the fill character. */
    public final void setShape(Shape shape) {
        for (int[] p : shape.points) {
            this.setCell(new int[]
                {shape.pos[0] + p[0], shape.pos[1] + p[1]});
        }
    }

    /** Prints the plane, with y=0 on the bottom. */
    public final void printPlane() {
        for (int line = this.height - 1; line >= 0; line--) {
            System.out.println(this.plane[line]);
        }
    }
}
