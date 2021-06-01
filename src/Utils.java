import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public abstract class Utils {
    public static final int[][] lineBetween(int[] point1, int[] point2) {
        //System.out.println("In lineBetween:");
        int x0 = point1[0];
        int y0 = point1[1];
        int xRange = point2[0]-x0;
        int yRange = point2[1]-y0;
        if (xRange==0) {
            return new int[][] {point1};
        }
        float slope = (float) yRange/xRange;
        int sign = xRange/Math.abs(xRange);
        int[][] line = new int[Math.abs(xRange)][2];
        for (int i=0; i<Math.abs(xRange); i++) {
            int x = x0 + i*sign;
            float y = y0 + x*slope;
            line[i][0] = Math.round(x);
            line[i][1] = Math.round(y);
        }
        //Utils.printPoints(line);
        return line;
    }

    public static final int[][] straightLine(int x, int y1, int y2) {
        int start = Math.min(y1, y2);
        int end = Math.max(y1, y2);
        int range = end-start;
        int[][] line = new int[range][2];
        for (int i=0; i<range; i++) {
            line[i] = new int[] {x, start+i};
        }
        return line;
    }

    public static final int[] reversePoint(int[] point) {
        int x = point[0];
        int y = point[1];
        return new int[] {y, x};
    }

    public static final int[][] reverseArray(int[][] array) {
        int[][] outArray = new int[array.length][2];
        for (int i=0; i<array.length; i++) {
            outArray[i] = Utils.reversePoint(array[i]);
        }
        return outArray;
    }

    public static final ArrayList<int[]> duplicateVertices(int[][] border) {
        ArrayList<int[]> borderList = new ArrayList<int[]>(border.length);
        int[] previous = border[border.length-2];
        int[] analyzing = border[border.length-1];
        for(int[] next : border) {
            borderList.add(analyzing);
            if (previous[0]==next[0]) {
                borderList.add(analyzing);
            }
            previous = analyzing;
            analyzing = next;
        }
        return borderList;
    }

    public static final int[][] fillBorder(int[][] border) {
        ArrayList<int[]> borderFixed = Utils.duplicateVertices(border);
        HashSet<int[]> fillPoints = new HashSet<int[]>(borderFixed);
        HashMap<Integer,Integer> unmatchedPoints = new HashMap<Integer,Integer>();
        for (int[] point : borderFixed) {
            int x = point[0];
            int y = point[1];
            if (unmatchedPoints.containsKey(x)) {
                fillPoints.addAll(Arrays.asList(Utils.straightLine(x, y, unmatchedPoints.get(x))));
                unmatchedPoints.remove(x);
            }
            else {
                unmatchedPoints.put(x, y);
            }
        }
        return fillPoints.toArray(border);
    }

    public static final void printPoints(int[][] points) {
        for (int[] point  : points) {
            System.out.println(Arrays.toString(point));
        }
    }
}
