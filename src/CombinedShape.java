import java.util.HashSet;

public class CombinedShape extends Shape{
    public CombinedShape(Shape[] components) {
        this.pos = components[0].pos;
        this.points = combineShapes(components);
    }

    public static HashSet<int[]> combineShapes(Shape[] components) {
        HashSet<int[]> outPoints = new HashSet<int[]>();
        int[] position = components[0].pos;
        for (Shape shape : components) {
            int relativeX = shape.pos[0] - position[0];
            int relativeY = shape.pos[1] - position[1];
            for (int[] point : shape.points) {
                outPoints.add(new int[]
                    {relativeX + point[0], relativeY + point[1]});
            }
        }
        return outPoints;
    }
}
