public class MyThread extends Thread {
    public static void main(String args[]) {
        MyThread t = new MyThread();
        t.start();
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {

        }
        public void main(String args[]) {
        Runnable r = new MyRunnable();
        Thread thObj=new Thread(r);
        thObj.start(); //Starting a thread
    }
    }
}