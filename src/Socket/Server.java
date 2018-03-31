package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //1.创建服务器端的socket,指定绑定的段鸥，并且监听此端口
        try  {
            ServerSocket serverSocket = new ServerSocket(8888);
            //调用accept方法开始监听，等待客户端的连接
            System.out.println("***服务器即将启动，等待客户端连接***" );
            Socket socket= serverSocket.accept();
            //3.获取输入流，读取客户端信息
            InputStream is= socket.getInputStream();//将字节流转化为字符流
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader br= new BufferedReader(isr);//为输入流添加缓冲
            String info= null;
            while ((info= br.readLine())!= null){
                System.out.println("客户端说："+info );
            }
            socket.shutdownInput();//关闭输入流
            //3.获取输出，响应客户端信息
            OutputStream os= socket.getOutputStream();
            //输出流包装为打印流
            PrintWriter pw=new PrintWriter(os);
            pw.write("欢迎你" );
            pw.flush();
            pw.close();
            os.close();
            //4.关闭相关资源
            br.close();
            is.close();
            isr.close();
            socket.close();
            serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
