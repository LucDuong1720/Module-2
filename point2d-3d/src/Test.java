public class Test {
    public static void main(String[] args) {
        Pointed2D p2d = new Pointed2D();
        System.out.println(p2d);

        p2d = new Pointed2D(2, 5);
        System.out.println(p2d);

        Pointed3D p3d = new Pointed3D();
        System.out.println(p3d);

        p3d = new Pointed3D(5, 6, 3);
        System.out.println(p3d);
    }
}
