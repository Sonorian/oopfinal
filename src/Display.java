public class Display {
    public char[][] plane;
    public char fill;
    public static int width = 99;
    public static int height = 14;
    private static final Display DISPLAY = new Display(width, height);

    protected Display(int x, int y) {
        this.plane = new char[y][x];
        this.fill = ' ';
    }

    public void debug() {
        System.out.println(this.plane.length);
        System.out.println(this.plane[0].length);
        System.out.println(this.fill);
        System.out.println(this.plane[0][0]);
        System.out.println(this.plane[0]);
    }

    public static final Display getDisplay() {
        return Display.DISPLAY;
    }

    public final void setDimensions(int width, int height) {
        this.plane = new char[height][width];
    }

    public final void setFill(char fillCharacter) {
        this.fill = fillCharacter;
    }

    public final void setCell(int[] point) {
        try {
            this.plane[point[1]][point[0]] = this.fill;
        }
        catch (ArrayIndexOutOfBoundsException e) {}
    }

    public final void setBackground() {
        for(int y=0; y<Display.height; y++) {
            for(int x=0; x<Display.width; x++) {
                this.setCell(new int[] {x,y});
            }
        }
    }

    public final void setShape(Shape shape) {
        for (int[] p : shape.points) {
            this.setCell(new int[] {shape.x+p[0], shape.y+p[1]});
        }
    }

    public final void printPlane() {
        for (int line=Display.height-1; line>=0; line--) {
            System.out.println(this.plane[line]);
        }
    }
}
