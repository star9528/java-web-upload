import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadVsThreadPool {

    public static void main(String[] args) {
        /**
         * 1.没有使用线程
         * 自己送快递，再自己干活
         */

        System.out.println("送快递取北京");//模拟送快递，有可能送快递比较耗时
        System.out.println("送快递到上海");
        System.out.println("处理自己的业务");

        /**
         * 2.使用手动创建线程
         * 雇佣了两个人，让他们送快递
         * 同时，我也在干自己的事
         */

        new Thread(() -> {
            System.out.println("送快递取北京");
        }).start();
        new Thread(() -> {
            System.out.println("送快递到上海");
        }).start();
        new Thread(() -> {
            System.out.println("处理自己的业务");
        }).start();


        /**
         * 3.使用JDK的线程池来送快递
         */
        //创建线程池对象：开一家快递公司，专门处理送快递的任务
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,//核心线程数，即快递公司正式员工————线程
                10,//最大线程数：总员工（正式工+临时工）————线程
                //临时工 + 空闲时间:正式员工数量不够处理任务时，招聘临时工，临时工超过空闲时间，就解雇
                60,//空闲时间数
                TimeUnit.SECONDS,//时间单位
                //阻塞队列：快递公司的仓库，保存快递包裹。——存放线程的容器
                new ArrayBlockingQueue<>(1000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                },
                //拒绝策略：接收到新快递单，但是此时仓库容量不够存放快递
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );
        pool.execute(() -> {
            System.out.println("送快递取北京");
        });
        pool.execute(() -> {
            System.out.println("送快递取上海");
        });
        pool.execute(() -> {
            System.out.println("干自己的事");
        });
    }
}
