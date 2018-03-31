package fileio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class myraf {
    public static void main(String[] args) throws IOException{
        File demo= new File("demo" );
        if(!demo.exists()){
            demo.mkdir();
        }
        File file= new File(demo,"raf.dat" );
        if(!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile raf= new RandomAccessFile(file,"rw" );
        //指针的位置
        System.out.println(raf.getFilePointer());
        raf.write('A');//只写一个字节
        System.out.println(raf.getFilePointer());
        raf.write('B');
        System.out.println(raf.getFilePointer());
        int i= 0xffffffff;//write()方法一次写一个字节，写i要写4字节,4次
        raf.write(i>>24);//高八位移到最后
        raf.write(i>>16);
        raf.write(i>>8);
        raf.write(i);
        System.out.println(raf.getFilePointer());
        //但是也可以直接写一个int
        raf.writeInt(i);
        //写中文
        String s= "中" ;
        byte[] b=s.getBytes("GBK" );
        raf.write(b);
        System.out.println(raf.getFilePointer());
        //读文件必须把指针移到头部
        raf.seek(0);
        //一次性读取,把文件内容读取到字节数组中
        byte[] a= new byte[(int)raf.length()];
        //读取字节数组
        raf.read(a);
        System.out.println(Arrays.toString(a));
        //或者构造成字符串
        /*String c= new String(a,"GBK" );//尤其不能忘记用什么构造就用什么参数
        System.out.println(a);*///这里不行因为你的编码方式是默认的编码方式utf-16be 而在写入“中” 这个汉字是
        // 转换为字节数组是 采用的是GBK编码方式    byte[] gbk=s.getBytes("gbk");  所以在文件中 存在2个GBK编码方式的字节。
        // 而在后面的读时 用的是默认的编码方式将文件里的提取出所有的。而又2个不是这种了类型的 则会出现乱码

    }
}
