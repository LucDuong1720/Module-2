public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColour("yellow");
        fan1.setOnOff(true);

        fan2.setSpeed(2);

        System.out.println(fan1);
        System.out.println(fan2);
    }
}
