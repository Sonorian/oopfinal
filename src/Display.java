public class Display {
    public char[][] plane;
    public char fill;
    public int width;
    public int height;
    private static final Display DISPLAY = new Display();

    protected Display() {
        this.width = 100;
        this.height = 14;
        this.plane = new char[this.height][this.width];
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
        this.width = width;
        this.height = height;
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
        for(int y=0; y<this.height; y++) {
            for(int x=0; x<this.width; x++) {
                this.setCell(new int[] {x,y});
            }
        }
    }

    public final void setShape(Shape shape) {
        for (int[] p : shape.points) {
            this.setCell(new int[] {shape.pos[0]+p[0], shape.pos[1]+p[1]});
        }
    }

    public final void printPlane() {
        for (int line=this.height-1; line>=0; line--) {
            System.out.println(this.plane[line]);
        }
    }
}
