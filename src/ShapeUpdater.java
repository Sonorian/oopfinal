/**
 * Simple base class for a persistent, changeable shape.
 * 
 * <p>The update and display methods are meant to be called once per EditCode.cycle(), 
 * to change and show the shape, respectively. 
 */
public abstract class ShapeUpdater {
    public Shape shape;
    protected char fill;

    /** Changes the shape. */
    public abstract void update();

    /** Adds the shape to the display. */
    public void display(Display display) {
        display.setFill(this.fill);
        display.setShape(this.shape);
    }

    /** Sets the fill character. */
    public void setFill(char fillCharacter) {
        this.fill = fillCharacter;
    }
}
