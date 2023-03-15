public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;

    private int speed = SLOW;
    private boolean onOff = false;
    private double radius = 5;
    private String colour = "blue";

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Fan(int speed, boolean onOff, double radius, String colour) {
        this.speed = speed;
        this.onOff = onOff;
        this.radius = radius;
        this.colour = colour;
    }

    @Override
    public String toString() {
        if (this.onOff == true) {
            return "Fan: " +
                    "speed: " + speed +
                    ", radius: " + radius +
                    ", colour: " + colour + ", Fan is on" + '\'';
        } return "Fan: " +
                "radius: " + radius +
                ", colour: " + colour + ", Fan is off" + '\'';

    }
}
