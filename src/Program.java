public final class Program{
    public final Display display;
    private static final Program PROGRAM = new Program();

    private Program() {
        this.display = Display.getDisplay();
    }

    public static final Program getProgram() {
        return Program.PROGRAM;
    }

    public final void setup() {
        EditCode.setup(this.display);
    }

    public final void run() {
        for (int i=0; i<EditCode.cycles; i++) {
            EditCode.cycle(this.display);
            this.display.printPlane();
            try {
                Thread.sleep(EditCode.frameDelay);
            }
            catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
