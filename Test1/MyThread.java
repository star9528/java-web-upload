package Test1;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        //main线程阻塞
        //线程休眠
        Thread.sleep(99999999999999L);
        //子线程阻塞
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程").start();
        //main线程和子线程都阻塞
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程").start();
        Thread.sleep(99999999999999L);
    }
}
