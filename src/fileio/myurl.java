package fileio;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class myurl {
    public static void main(String[] args){
        try {
            URL imooc= new URL("http://www.imooc.com" );
            URL url= new URL(imooc,"/index.html?username= tom#test" );
            //问好后表示参数，井号后表示锚点
            System.out.println("协议："+url.getProtocol() );
            System.out.println("主机："+url.getHost() );
            //若未指定端口号，则使用默认端口号，此时getPort方法返回-1
            System.out.println("端口："+url.getPort() );
            System.out.println("文件路径："+url.getPath() );
            System.out.println("文件名："+url.getFile() );
            System.out.println("相对路径："+url.getRef() );
            System.out.println("查询字符串："+url.getQuery() );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            URL url1= new URL("http://www.baidu.com" );
            //通过该方法获取URL对象所表示的资源的字节输入流
            InputStream is= url1.openStream();
            //通过将字节输入流转化为字符输入流
            InputStreamReader isr= new InputStreamReader(is);
            //为字符输入流添加缓冲
            BufferedReader br= new BufferedReader(isr);
            String data= br.readLine();
            while(data!= null){//循环读取数据
                System.out.println(data);
                data= br.readLine();
            }
            br.close();
            is.close();
            isr.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
