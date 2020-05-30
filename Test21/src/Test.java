public class Test {
    private static int SUM;

    public static synchronized void increment(int n) {
        SUM++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increment(j);
                }
            }).start();
        }
        while (Thread.activeCount() > 1)
            //让当前线程让步，即当前线程由运行态转变为就绪态
            Thread.yield();
        System.out.println(SUM);
    }
}