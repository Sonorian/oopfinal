public final class EditCode {
    private static final EditCode codeInstance = new EditCode();
    public final int cycles; // number of cycles to run the program for
    public final int frameDelay; // time between frames in milliseconds

    private EditCode() {
        this.cycles = 30;
        this.frameDelay = 200;
    }

    public static final EditCode getCode() {
        return EditCode.codeInstance;
    }

    // Declare your own fields and methods here
    CustomPolygon poly;

    public final void setup(Display display) {
        /**
         * Your initializations here
         * 
         * Useful for things like display.setDimensions(width, height); (default is 100x14 characters)
         */
    }

    public final void cycle(Display display) {
        /**
         * Your instructions here
         * 
         * Generally, you'll want to have
         *  display.setFill('background character');
         *  display.setBackground;
         * somewhere near the start to reset the background each loop
         */
    }
}
