package Socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        //创建客户端socket,指定端口
        try (Socket socket = new Socket("localhost", 8888)) {
            //2.获取输出流，向服务器端输出信息
            OutputStream os= socket.getOutputStream();
            //输出流包装为打印流
            PrintWriter pw=new PrintWriter(os);
            //
            pw.write("用户名：admin；密码：123" );
            pw.flush();//刷新缓冲
            socket.shutdownOutput();//关闭输出流
            //响应服务端
            InputStream is= socket.getInputStream();//将字节流转化为字符流
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader br= new BufferedReader(isr);//为输入流添加缓冲
            String info= null;
            while ((info= br.readLine())!= null){
                System.out.println("服务端说："+info );
            }
            // 关闭其他资源
            is.close();
            isr.close();
            br.close();
            pw.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
