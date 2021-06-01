public abstract class ShapeUpdater {
    Shape shape;
    char fill;

    public abstract void update();

    public void display(Display display) {
        display.setFill(this.fill);
        display.setShape(this.shape);
    }

    public void setFill(char fillCharacter) {
        this.fill = fillCharacter;
    }
}
