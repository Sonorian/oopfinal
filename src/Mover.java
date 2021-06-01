public class Mover extends ShapeUpdater {
    int[] velocity;

    public Mover(Shape shape, int[] velocity) {
        this.shape = shape;
        this.velocity = velocity;
    }

    public void update() {
        this.move();
    }

    public void move() {
        int[] position = this.shape.pos;
        position[0] += this.velocity[0];
        position[1] += this.velocity[1];
        this.shape.setPosition(position);
    }
}
