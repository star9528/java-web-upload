public class SequencePrint {
    public static void print2() {
        Thread t1 = new Thread(new Print("A"));
        Thread t2 = new Thread(new Print("B"));
        Thread t3 = new Thread(new Print("C"));

        t1.start();
        t2.start();
        t3.start();
    }

    private static class Print implements Runnable {
        private String content;
        private static String[] ARRAY = {"A", "B", "C"};
        private static int INDEX;

        public Print(String content) {
            this.content = content;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (ARRAY) {
                        while (!ARRAY[INDEX].equals(content)) {
                            ARRAY.wait();
                        }
                        System.out.print(content);
                        if (INDEX == ARRAY.length - 1) {
                            System.out.println();
                        }
                        INDEX = (INDEX + 1) % ARRAY.length;
                        ARRAY.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        print2();
    }
}
