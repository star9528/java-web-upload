/**
 * 三个线程
 * 第一个打印A，第二个打印B，第三个打印C
 * 要求的打印结果
 */

public class SequencePrint {

    public static void print1() {
        Thread t1 = new Thread(new Print("A", null));
        Thread t2 = new Thread(new Print("B", t1));
        Thread t3 = new Thread(new Print("C", t2));

        t3.start();
        t2.start();
        t1.start();
    }

    public static void main(String[] args) throws InterruptedException {
        print1();
    }

    private static class Print implements Runnable {
        private String content;
        private Thread t;

        public Print(String content, Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {
            try {
                if (t != null) {
                    t.join();
                }
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
