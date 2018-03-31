package fileio;

import java.io.FileInputStream;
import java.io.IOException;

public class myioutils {
    //读取指定文件内容，按照十六进制输出到控制台。
    //并且没输出是个byte换行
    public static void printHex(String filename)throws IOException{
        //把文件作为字节流进行读操作
        FileInputStream in= new FileInputStream(filename);
        int b;
        int i= 1;

        while((b= in.read())!= -1){//没读到结尾,in.read()返回的是0和-1
            if(b<= 0xf){
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b)+" " );
            if(i++%10== 0){
                System.out.println();
            }
        }
        System.out.println(in.read());
        in.close();
    }
    public static void printHexByByteArrays(String filename)throws IOException{
        FileInputStream in= new FileInputStream(filename);
        byte[] buf= new byte[20*1024];
        //从in中批量读取字节到字节数组，从第0个位置开始放，最多放buf.length个
        //返回的是得到字节的个数bytes
        int bytes= in.read(buf,0,buf.length);
        int j= 1;
        for (int i = 0; i <bytes ; i++) {
            if(buf[i] <= 0xf){
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(buf[i])+" " );
            if(j++%10== 0){
                System.out.println();
            }
        }
        in.close();
    }
}
