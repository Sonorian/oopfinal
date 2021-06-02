import java.util.HashSet;

public class Point extends Shape{
    Point(int[] position) {
        this.pos = position;
        this.points = new HashSet<int[]>(1);
        this.points.add(new int[] {0,0});
    }
}
