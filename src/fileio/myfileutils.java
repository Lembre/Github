package fileio;

import java.io.File;
import java.io.IOException;

public class myfileutils {
    //列出指定目录下的所有文件
    public static void listDirectory(File dir)throws IOException{
        if(!dir.exists()){
            throw new IllegalArgumentException("目录"+dir+"不存在" );
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录" );
        }
        /*String[] filename= dir.list();
        for(String str:filename){
            System.out.println(dir+"\\"   +str);
        }*/
        File[] files= dir.listFiles();
        if(files!= null && files.length>0){
            for (File file:files)
            {
                if (file.isDirectory()){
                    //递归又调用了listDirecrory()一次，目的是找出子目录下的内容
                    listDirectory(file);
                }else {
                    System.out.println(file);
                }
            }
        }
    }
}
