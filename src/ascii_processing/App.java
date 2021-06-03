package ascii_processing;

/** Runs the program. */
public class App {
    public static void main(String[] args) throws Exception {
        Program program = Program.getProgram();
        program.setup();
        program.run();
    }
}
