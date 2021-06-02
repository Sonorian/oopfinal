import java.util.HashSet;

public class Circle extends Shape {
    public Circle(int[] position, int radius) {
        this.pos = position;
        HashSet<int[]> pointSet = new HashSet<int[]>();
        for (int y=0; y<radius; y++) {
            for (int x=0; x<radius; x++) {
                if (x*x+y*y<=radius*radius) {
                    pointSet.add(new int[] {x,y});
                    pointSet.add(new int[] {-x,y});
                    pointSet.add(new int[] {-x,-y});
                    pointSet.add(new int[] {x,-y});
                }
            }
        }
        this.points = pointSet;
    }
}
