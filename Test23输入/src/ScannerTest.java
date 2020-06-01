import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //给定一组测试用例10个,接收每个用例
        //假设，接收的输入为：
        //2
        //3 1 10 31
        //hasNextxxx() 和 hasNextxxx() 读取io数据知到满足条件(空格和换行),否则阻塞等待
        //io流只能操作一次.hasNextxxx()不操作,只判断.nextxxx()读取一下,io流跑到下一个读取位置
        while (scanner.hasNextInt()){
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                int data = scanner.nextInt();
                System.out.println(data);
            }
        }
//        //2
//        //3 1 10 31
//        while (scanner.hasNextLine()){
//            String s = scanner.nextLine();//4
//            String next = scanner.nextLine();//3 1 10 31
//        }
    }
}
