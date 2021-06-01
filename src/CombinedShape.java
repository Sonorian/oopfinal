import java.util.HashSet;

public class CombinedShape extends Shape{

    public CombinedShape(Shape[] components) {
        this.x = components[0].x;
        this.y = components[0].y;

        HashSet<int[]> pointSet = new HashSet<int[]>();
        for (Shape shape : components) {
            for (int[] point : shape.points) {
                int relativeX = (shape.x-this.x)+point[0];
                int relativeY = (shape.y-this.y)+point[1];
                pointSet.add(new int[] {relativeX, relativeY});
            }
        }
        this.points = pointSet.toArray(new int[1][2]);
    }
    
}
