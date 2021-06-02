import java.util.HashSet;

public class CombinedShape extends Shape{

    public CombinedShape(Shape[] components) {
        this.pos = components[0].pos;
        this.points = new HashSet<int[]>();
        for (Shape shape : components) {
            for (int[] point : shape.points) {
                int relativeX = (shape.pos[0]-this.pos[0])+point[0];
                int relativeY = (shape.pos[1]-this.pos[1])+point[1];
                this.points.add(new int[] {relativeX, relativeY});
            }
        }
    }
    
}
