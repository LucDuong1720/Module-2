import java.util.Arrays;

public class Pointed2D {
    protected float x;
    protected float y;

    public Pointed2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Pointed2D() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float [] getXY(float arr[], float x, float y) {
        return arr = new float[]{x,y};
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ")";
    }
}