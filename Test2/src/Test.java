public class Test {
    public static void main(String[] args) {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(99999999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"多线程");
//        t.run();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程");
            }
        },"线程").start();
        System.out.println("main");
    }
}
