import org.junit.Test;

import java.io.*;

public class FileIOTest {
    //字节流
    @Test
    public void t1() throws IOException {
        //文件输入字节流
        //FileInputStream fis = null;
        InputStream fis = null;
        //File中的路径
        //第一种方式：使用FileInputStream + 绝对路径。
        // 第二种，使用ClassLoader+相对路径（推荐）
        try {
//            fis = new FileInputStream(new File("E:\C语言项目\java web2\Test28\data\s.txt"));
            fis = this.getClass().getClassLoader().getResourceAsStream("s.txt");
            //读取操作，从当前位置偏移多少位（read. new String中的第二个参数）,读读多长(第三个参数)
            byte[] bytes = new byte[1024];
            //读取长度
            int len;
            while ((len = fis.read(bytes)) != -1) { //不等于-1 表示文件还没有读到最后一个位置
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
            //即使有异常,也会是放流
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    //字符流
    @Test
    public void t2() throws IOException {
        FileReader reader = new FileReader("E:\\C语言项目\\java web2\\Test28\\data\\s.txt");
        char[] chars = new char[1024];
        //读取长度
        int len;
        while ((len = reader.read(chars)) != -1) { //不等于-1 表示文件还没有读到最后一个位置
            String s = new String(chars, 0, len);
            System.out.println(s);
        }
    }

    @Test
    public void t3() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\C语言项目\\java web2\\Test28\\data\\s.txt");
        //字节字符转换流,指定编码格式,java编译的编码如果和目标文件的编码格式不一致,就会出现乱码
        InputStreamReader isr = new InputStreamReader(fis,"GBK");
        //缓冲流
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void t4() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\C语言项目\\java web2\\Test28\\data\\s.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[1024];
        //读取长度
        int len;
        while ((len = fis.read(bytes)) != -1) { //不等于-1 表示文件还没有读到最后一个位置
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
    }

    //输出

    @Test
    public void t5() throws IOException {
        //覆盖的形式
        FileOutputStream fos = new FileOutputStream("E:\\C语言项目\\java web2\\Test28\\data\\s.txt");
        //追加的形式(追加到文件末尾)
//        FileOutputStream fos = new FileOutputStream("E:\\C语言项目\\java web2\\Test28\\data\\s.txt",true);
//        PrintWriter pw = new PrintWriter(fos);
        PrintWriter pw = new PrintWriter(fos,true);//自动刷新
        pw.println("追加1");
        pw.println("追加2");
        pw.println("追加3");
//        pw.flush();//手动刷新缓冲区
    }

    @Test
    public void t6() throws IOException {
       //覆盖的形式
        FileOutputStream fos = new FileOutputStream("E:\\C语言项目\\java web2\\Test28\\data\\s.txt");
        //追加的形式(追加到文件末尾)
//        FileOutputStream fos = new FileOutputStream("E:\\C语言项目\\java web2\\Test28\\data\\s.txt",true);
        //字节转为字符输出流
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        //转换为缓冲输出流
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("追加1");
        bw.newLine();
        bw.write("追加2");
        bw.newLine();
        bw.write("追加3");
        bw.newLine();
        bw.close();
    }
}
