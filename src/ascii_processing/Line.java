package ascii_processing;

import java.util.ArrayList;

/** A Shape that's a line between 2 points. */
public class Line extends Shape {
    /**
     * Creates a Line.
     * 
     * @see Utils#lineBetween(int[], int[])
     * 
     * @param point1 the starting point
     * @param point2 the ending point
     */
    public Line(int[] point1, int[] point2) {
        this.pos = point1;
        int[] relativePoint = new int[]
            {point2[0] - this.pos[0], point2[1] - this.pos[1]};
        int diffXY = Math.abs(relativePoint[1]) - Math.abs(relativePoint[0]);
        if (diffXY > 0) {
            // If slope is steeper than 1, make the line a function of y.
            relativePoint = Shape.reversePoint(relativePoint);
        }
        ArrayList<int[]> pointsBetween = Shape.lineBetween(new int[] {0, 0}, relativePoint);
        this.points = new RelativePoints(pointsBetween);
        this.points.add(relativePoint);
        if (diffXY > 0) {
            // If the line is a function of y, this.points will be stored as (y,x).
            // This reverses it back. 
            this.points.reversePoints();
        }
    }
}
