/** User-editable code. */
public final class EditCode {
    /** EditCode singleton instance. */
    private static final EditCode codeInstance = new EditCode();
    /** Number of cycles to run the program for. */
    public final int cycles;
    /** Time between frames in milliseconds. */
    public final int frameDelay;

    /** Makes the EditCode instance.*/
    private EditCode() {
        this.cycles = 30;
        this.frameDelay = 200;
    }

    /** Returns the EditCode instance.*/
    public static final EditCode getCode() {
        return EditCode.codeInstance;
    }

    /* DO NOT EDIT ANYTHING ABOVE THIS LINE */

    /* Declare your own things here. */

    /** 
     * User-generated code to run once. 
     * 
     * <p>Useful for setting things like
     * {@link EditCode.cycles} (default 30 cycles), 
     * {@link EditCode.frameDelay} (default 200 ms),
     * {@link Display.setDimensions} (default 100*14),
     * or anything else to just run once.
     * 
     * @see Program.setup
     */
    public final void setup(Display display) {
        /* Your initializations here */
    }

    /** 
     * User-generated code to run each cycle.
     * 
     * @see Program.run
     */
    public final void cycle(Display display) {
        /* Your instructions here */
    }
}
