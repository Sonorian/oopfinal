public final class Program{
    public final Display display;
    private final EditCode code;
    private static final Program PROGRAM = new Program();

    private Program() {
        this.display = Display.getDisplay();
        this.code = EditCode.getCode();
    }

    public static final Program getProgram() {
        return Program.PROGRAM;
    }

    public final void setup() {
        this.code.setup(this.display);
    }

    public final void run() {
        for (int i=0; i<this.code.cycles; i++) {
            this.code.cycle(this.display);
            this.display.printPlane();
            try {
                Thread.sleep(this.code.frameDelay);
            }
            catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
