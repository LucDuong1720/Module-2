public class Square extends Rectangle{
    public Square()
    {}
    public Square(double size) {
        super(size,size);
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled, side, side);
    }
    public double setSize() {
        return getWidth();
    }
    public void setSize(double size) {
        setLength(size);
        setWidth(size);
    }
    public void getWidth(double width) {
        setSize(width);
    }
    @Override
    public void setLength(double length) {
        setSize(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getWidth()
                + ", which is a subclass of "
                + super.toString();
    }
}
