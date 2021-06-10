package ascii_processing;

/**
 * Singleton class for the contents of the screen.
 * 
 * <p>Everything that changes what is displayed is a method of this class.
 */
public class Display {
    /** The characters to be printed. */
    public char[][] plane;
    /** The character to write to the plane. */
    public char fill;
    /** The width of the plane. */
    public int width;
    /** The height of the plane. */
    public int height;
    /** The Display instance */
    private static final Display displayInstance = new Display();

    /** Makes the Display. */
    private Display() {
        this.width = 100;
        this.height = 14;
        this.plane = new char[this.height][this.width];
        this.fill = ' ';
    }

    /** 
     * Returns the Display instance.
     * 
     * @return the Display instance
     */
    public static final Display getDisplay() {
        return Display.displayInstance;
    }

    /**
     * Modifies the width and height of the plane, and clears it.
     * 
     * @param width new width of the plane
     * @param height new height of the plane
     */
    public final void setDimensions(int width, int height) {
        this.plane = new char[height][width];
        this.width = width;
        this.height = height;
    }

    /** 
     * Sets the fill character.
     * 
     * @param fillCharacter new fill character
     */
    public final void setFill(char fillCharacter) {
        this.fill = fillCharacter;
    }

    /**
     * Changes one cell of the plane to the fill character.
     * 
     * @param point point on {@link Display#plane} to change
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

    /** Sets a Shape to the fill character. 
     * 
     * @param shape {@link Shape} to be added to {@link Display#plane}
     */
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
