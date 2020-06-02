import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    //根据路径找文件
    @Test
    public void t1(){
        //文件的相对路径和绝对路径
        //绝对路径：全路径.相对路径：./(当前目录).../(上一级目录)
        //java项目
        //全路径
        File file = new File("E:\\C语言项目\\java web2\\Test23\\data\\s.txt");
        //exists()文件是否存在
        System.out.println(file.exists());
        //相对路径
        File file1 = new File("..\\data\\s.txt");
        System.out.println(file1.exists());
        //怎么看当前java代码的路径
        File file2 = new File(".");//获取绝对路径
        System.out.println(file2.getAbsolutePath());

        File file3 = new File("data/s.txt");//file 类尽量不要在真实的项目中使用
        System.out.println(file3.exists());//文件是否存在
        System.out.println(file3.getPath());//获取路径
        System.out.println(file3.lastModified());//上次修改时间

    }

    //打印文件名
    @Test
    public void t2() {
        File file4 = new File("E:\\C语言项目\\java web2");
        File[] children = file4.listFiles();//返回目录下一级子文件
        for(File child : children) {
            System.out.println(child.getName());//打印文件名
        }
    }

    //递归打印所有文件名
    public static List<File> list(File f) {
        List<File> files = new ArrayList<>();
        if (f.isFile()) {
            files.add(f);
        }else{
            //下一级子文件，子文件夹
            File[] children  = f.listFiles();
            for(File child : children) {
                List<File> subs = list(child);
                files.addAll(subs);
            }
        }
        return files;
    }
    @Test
    public void t3() {
        File file4 = new File("E:\\C语言项目\\java web2");
        List<File> children = list(file4);//返回目录下一级子文件/子文件夹数组
        for(File child : children) {
            System.out.println(child.getName());//打印文件名
        }
    }
}
