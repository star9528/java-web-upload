public class SynchronizedTest {

    private Object o = new Object();
    private  static  Object T = SynchronizedTest.class;

    public static synchronized void t1() throws InterruptedException {
        Thread.sleep(999999999L);
    }

    public synchronized void t2() throws InterruptedException {
        Thread.sleep(999999999L);
    }

    public void t3() throws InterruptedException {
        synchronized (o) {
            Thread.sleep(999999999L);
        }
    }

    public  void t4() throws InterruptedException {
        synchronized (T) {
            Thread.sleep(999999999L);
        }
    }
}
