import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public abstract class Utils {
    public static final ArrayList<int[]> lineBetween(int[] point1, int[] point2) {
        int x0 = point1[0];
        int y0 = point1[1];
        int xRange = point2[0]-x0;
        int yRange = point2[1]-y0;
        ArrayList<int[]> line = new ArrayList<int[]>(xRange+1);
        if (xRange == 0) {
            line.add(point1);
            return line;
        }
        float slope = (float) yRange/xRange;
        int sign = xRange/Math.abs(xRange);
        for (int i=0; i<Math.abs(xRange); i++) {
            int x = x0 + i*sign;
            float y = y0 + x*slope;
            int[] point = new int[] {Math.round(x),Math.round(y)};
            line.add(point);
        }
        return line;
    }

    public static final ArrayList<int[]> straightLine(int[] point1, int[] point2) {
        int start = Math.min(point1[1], point2[1]);
        int end = Math.max(point1[1], point2[1]);
        int range = end-start;
        ArrayList<int[]> line = new ArrayList<int[]>(range);
        for (int i=0; i<range; i++) {
            line.add(new int[] {point1[0], start+i});
        }
        return line;
    }

    public static final int[] reversePoint(int[] point) {
        int x = point[0];
        int y = point[1];
        return new int[] {y, x};
    }

    public static final HashSet<int[]> reversePoints(HashSet<int[]> points) {
        HashSet<int[]> outSet = new HashSet<int[]>(points);
        for (int[] point : points) {
            outSet.add(Utils.reversePoint(point));
        }
        return outSet;
    }

    public static final ArrayList<int[]> duplicateVertices(ArrayList<int[]> border) {
        ArrayList<int[]> borderFixed = new ArrayList<int[]>(border.size());
        int[] previous = border.get(border.size()-2);
        int[] analyzing = border.get(border.size()-1);
        for(int[] next : border) {
            borderFixed.add(analyzing);
            if (previous[0]==next[0]) {
                borderFixed.add(analyzing);
            }
            previous = analyzing;
            analyzing = next;
        }
        return borderFixed;
    }

    public static final HashSet<int[]> fillBorder(ArrayList<int[]> border) {
        ArrayList<int[]> borderFixed = Utils.duplicateVertices(border);
        HashSet<int[]> fillPoints = new HashSet<int[]>(borderFixed);
        HashMap<Integer,int[]> unmatchedPoints = new HashMap<Integer,int[]>();
        for (int[] point : borderFixed) {
            int x = point[0];
            if (unmatchedPoints.containsKey(x)) {
                fillPoints.addAll(Utils.straightLine(point, unmatchedPoints.get(x)));
                unmatchedPoints.remove(x);
            }
            else {
                unmatchedPoints.put(x, point);
            }
        }
        return fillPoints;
    }

    public static final void printPoints(int[][] points) {
        for (int[] point  : points) {
            System.out.println(Arrays.toString(point));
        }
    }
}
