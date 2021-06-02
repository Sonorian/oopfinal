import java.util.HashSet;

public abstract class Shape {
    int[] pos; // [x,y] position of the shape
    HashSet<int[]> points; // An array of all points in the shape relative to its position

    public void setPosition(int[] newPosition) {
        this.pos = newPosition;
    }
}
