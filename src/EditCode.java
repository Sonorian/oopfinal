public final class EditCode {
    private static final EditCode CODE = new EditCode();
    public static final int cycles = 50; // number of cycles to run the program for
    public static final int frameDelay = 200; // time between frames in milliseconds

    private EditCode() {}
    public static final EditCode getCode() {
        return EditCode.CODE;
    }

    // Declare your own fields and methods here

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
