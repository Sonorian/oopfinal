/** A ShapeUpdater that moves. 
 * 
 * @see Shape
*/
public class Mover extends ShapeUpdater {
    int[] velocity;

    /**
     * Makes a Mover.
     * 
     * @param shape the mover's shape
     * @param velocity the mover's x,y velocity
     */
    public Mover(Shape shape, int[] velocity) {
        this.shape = shape;
        this.velocity = velocity;
    }

    @Override
    public void update() {
        this.move();
    }

    /** Adds its velocity to its position. */
    public void move() {
        int[] position = this.shape.pos;
        position[0] += this.velocity[0];
        position[1] += this.velocity[1];
        this.shape.setPosition(position);
    }
}
