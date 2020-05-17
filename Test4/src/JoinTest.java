//join 的使用和理解
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Thread Baby");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        //此时是先执行子线程，再执行 main 线程
        //在这里等待子线程死亡再往下执行
//        t.join();
        //在这里等待 1 秒钟，此时 Thread.sleep 也只是等待了一秒钟，不能往下执行，
        // 但是这里的 t.join 等待 1 秒钟之后就能往下只能够行了，此时就先打印 main
        //总结：在这里等待一秒之后往下执行
        t.join(1000);
        System.out.println("main");
    }
}
