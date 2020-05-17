public class InterruptTread {
    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> {
//            try {
//                while   (!Thread.interrupted()) {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(1000000000000L);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t.start();
//        Thread.sleep(2000);
//        t.interrupt();


//        Thread t = new Thread(() -> {
//                while   (!Thread.interrupted()) {
//
//                    try {
//                        System.out.println(Thread.currentThread().getName());
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//        });
//        t.start();
//        Thread.sleep(3000);
//        t.interrupt();


//        Thread t = new Thread(() -> {
//            for (int i = 0; i <  10;i++) {
//                System.out.println(Thread.interrupted());
//            }
//        });
//        t.start();
//        t.interrupt();
//    }


        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();
        t.interrupt();
    }
}
