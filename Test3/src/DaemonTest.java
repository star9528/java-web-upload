//用户线程转换为守护线程
public class DaemonTest {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"多线程");
        //下面这个代码只把子线程转从用户线程转换为守护线程，此时由于程序中没有用户线程，运行会将会直接退出，不会再休眠
        t.setDaemon(true);
        t.start();
    }
}
