package fileio;

import java.io.File;
import java.io.IOException;

public class Myfile {
    public static void main(String[] args) {
        File file= new File("C:\\Users\\Administrator\\Desktop\\Test" );
        File file1= new File("e:" +File.separator+"Film" );
        File file2= new File("e:\\Test.txt" );
        System.out.println(file1.exists());
        /*if(!file.exists()){
            file.mkdir();
        }else{
            file.delete();
        }*/
        System.out.println(file1.isDirectory());//注意不存在也返回false
        System.out.println(file1.isFile());
        if(!file2.exists()){
            try{
                file2.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }//常用File对象的API
        }
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.getParentFile());
    }
}
