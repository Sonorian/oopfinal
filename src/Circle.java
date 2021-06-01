import java.util.HashSet;

public class Circle extends Shape {
    public Circle(int[] pos, int radius) {
        this.x = pos[0];
        this.y = pos[1];
        HashSet<int[]> pointSet = new HashSet<int[]>();
        for (int y=0; y<radius; y++) {
            for (int x=0; x<radius; x++) {
                if (x*x+y*y<=radius*radius) {
                    pointSet.add(new int[] {x,y});
                    //pointSet.add(new int[] {-x,y});
                    //pointSet.add(new int[] {-x,-y});
                    //pointSet.add(new int[] {x,-y});
                }
            }
        }
        this.points = pointSet.toArray(new int[0][0]);
    }
}
