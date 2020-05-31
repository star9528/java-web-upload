public class SynchronizedTest {
    private Object o = new Object();
    private static Object T = SynchronizedTest.class;

    public static synchronized void t1() throws InterruptedException {
        Thread.sleep(999999999);
    }
    public synchronized void t2() throws InterruptedException {
        Thread.sleep(999999999);
    }
    public void t3() throws InterruptedException{
        synchronized (o){
            Thread.sleep(999999999);
        }
    }
    public void t4() throws InterruptedException{
        synchronized (T){
            Thread.sleep(999999999);
        }
    }
    public static void main(String[] args) {
        //t2方法在不同线程中执行时，是否有同步互斥
        // 情况一：不会同步互斥（不同对象）
        new Thread(()->{
            try {
                new SynchronizedTest().t2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                new SynchronizedTest().t2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //情况二：同一个对象，同步互斥
        SynchronizedTest t = new SynchronizedTest();
        new Thread(()->{
            try {
                t.t2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                t.t2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //直接使用枚举类
        Thread.State s = Thread.State.NEW;
        for(Thread.State state : Thread.State.values()){
            System.out.println(state);
        }
    }
}
