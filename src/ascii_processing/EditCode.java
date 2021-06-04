package ascii_processing;

/** User-editable code. */
public final class EditCode {
    /** EditCode singleton instance. */
    private static final EditCode codeInstance = new EditCode();
    /** Number of cycles to run the program for. */
    public int cycles;
    /** Time between frames in milliseconds. */
    public int frameDelay;

    /** Makes the EditCode instance.*/
    private EditCode() {
        this.cycles = 30;
        this.frameDelay = 200;
    }

    /** Returns the EditCode instance.*/
    public static final EditCode getCode() {
        return EditCode.codeInstance;
    }

    /* !!! DO NOT EDIT ANYTHING ABOVE THIS LINE !!! */

    /* Declare your own things here. */
    Border border; // Uses Border and Mover via composition
    Mover point;   // There are examples of this in the actual code too

    /** 
     * User-generated code to run once. 
     * 
     * <p>Useful for setting things like
     * {@link EditCode#cycles} (default 30 cycles), 
     * {@link EditCode#frameDelay} (default 200 ms),
     * {@link Display#setDimensions(int, int)} (default 100*14),
     * or anything else to just run once.
     * 
     * @see Program#setup()
     * 
     * @param display {@link Display#getDisplay()}
     */
    public final void setup(Display display) {
        /* Your initializations here */
        this.cycles = 46;
        display.setDimensions(50, 5);
        this.border = new Border();
        this.point = new Mover(new Point(new int[] {1,2}), new int[] {1,0});
        this.point.setFill('0');
    }

    /** 
     * User-generated code to run each cycle.
     * 
     * @see Program#run()
     * 
     * @param display {@link Display#getDisplay()}
     */
    public final void cycle(Display display) {
        /* Your instructions here */
        display.setFill('.');
        display.setBackground();
        display.setFill('+');
        display.setShape(this.border);
        this.point.update();
        this.point.display();
    }
}
