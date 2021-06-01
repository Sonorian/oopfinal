public abstract class Shape {
    int[] pos; // [x,y] position of the shape
    int[][] points; // An array of all points in the shape relative to its position

    public void setPosition(int[] newPosition) {
        this.pos = newPosition;
    }
}
