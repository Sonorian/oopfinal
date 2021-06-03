# ASCII Processing

A barebones Processing clone using ASCII characters. The repo is called oopfinal because I'm bad at git.

## How to use

Edit the EditCode class. Stuff in the `setup()` method gets run once. Stuff in the `cycle()` method gets run `cycles` times with `frameDelay` milliseconds between each. There are lots of "fun" and "exciting" classes for shapes. Or you could extend your own. I'm good at writing instructions.

Full reference is in the /api folder. Just open one of the html files, they all link to each other I think.

## Example Code

A simple program that moves a point across the screen. Demonstrates both Shapes and Movers. 
```java
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
        display.setFill('.');
        display.setBackground();
        display.setFill('+');
        display.setShape(this.border);
        this.point.update();
        this.point.display();
    }
}
```
