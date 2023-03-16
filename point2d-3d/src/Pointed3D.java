public class Pointed3D extends Pointed2D{
    protected float z;

    public Pointed3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Pointed3D() {

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z) {
        super.getX();
        super.getY();
        this.z = z;
    }
    public float [] getXYZ(float arr [], float x, float y, float z) {
        return arr = new float[]{x, y, z};
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ", " + z +
                ')';
    }
}
