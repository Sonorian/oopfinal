import java.util.Arrays;

public class Line extends Shape {
    public Line(int[] point1, int[] point2) {
        this.pos = point1;
        int [] relativePoint = new int[] {point2[0]-this.pos[0], point2[0]-this.pos[1]};
        int diffXY = Math.abs(relativePoint[1])-Math.abs(relativePoint[0]);
        if (diffXY > 0) {
            //If slope is steeper than 1, make the line a function of y
            relativePoint = Utils.reversePoint(relativePoint);
        }
        int[][] pointsBetween = Utils.lineBetween(new int[] {0,0}, relativePoint);
        this.points = Arrays.copyOf(pointsBetween, pointsBetween.length+1);
        this.points[pointsBetween.length] = relativePoint;
        if (diffXY > 0) {
            this.points = Utils.reverseArray(this.points);
        }
    }
}
