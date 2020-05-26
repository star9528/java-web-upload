/**
 * 阻塞式队列
 * （1）基于数组的循环队列实现
 * （2）提供一个队列，取元素的时候，
 * 如果队列为空，阻塞等待。
 * 如果队列满了，存元素的时候，阻塞等待
 */

public class MyBlockQueue<T> {

    private Object[] table;
    private int takeIndex = 0;
    private int putIndex = 0;
    //队列元素
    private int size = 0;

    public MyBlockQueue(int capacity) {
        table = new Object[capacity];
    }

    public synchronized void put(T element) throws InterruptedException {
        while (size == table.length) {
            wait();
        }
        table[putIndex] = element;//存放元素
        putIndex = (putIndex + 1) % table.length;
        size++;
        notifyAll();
    }

    public synchronized T take(T i) throws InterruptedException {
        while (size == 0) {
            wait();
        }
        Object element = table[takeIndex];//取元素
        takeIndex = (takeIndex + 1) % table.length;
        size--;
        notifyAll();
        return (T)element;
    }


    //模拟使用自己定义阻塞队列
    public static void main(String[] args) {
        MyBlockQueue<Integer> queue = new MyBlockQueue(100);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        //模拟生产面包
                        queue.put(3);
                        System.out.println("生产面包 + 1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        //模拟消费面包
                        Integer e = queue.take(3);
                        System.out.println("消费面包 - 1");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}

