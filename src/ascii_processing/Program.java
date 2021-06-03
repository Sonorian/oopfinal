/** 
 * Runs the user's code. 
 * 
 * @see EditCode
*/
public final class Program{
    public final Display display;
    private final EditCode code;
    private static final Program programInstance = new Program();

    /** Makes the Program instance. */
    private Program() {
        this.display = Display.getDisplay();
        this.code = EditCode.getCode();
    }

    /** Returns the Program instance. */
    public static final Program getProgram() {
        return Program.programInstance;
    }

    /** 
     * Runs the user's setup method.
     * 
     * @see EditCode#setup(Display)
     */
    public final void setup() {
        this.code.setup(this.display);
    }

    /** 
     * Repeatedly runs the user's cycle method.
     * 
     * @see EditCode#cycle(Display)
     */
    public final void run() {
        for (int i = 0; i < this.code.cycles; i++) {
            this.code.cycle(this.display);
            this.display.printPlane();
            try {
                Thread.sleep(this.code.frameDelay);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
