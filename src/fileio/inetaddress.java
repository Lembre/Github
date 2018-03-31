package fileio;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class inetaddress {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress实例
        InetAddress address= InetAddress.getLocalHost();
        System.out.println("计算机名称："+address.getHostName() );
        System.out.println("主机IP地址："+address.getHostAddress() );
        byte[] bytes= address.getAddress();//字节数组形式输出IP地址
        System.out.println(Arrays.toString(bytes));
        System.out.println(address);//直接输出InetAddress对象
        //根据机器名获取InetAddress实例
        System.out.println("********************" );
        InetAddress address1=InetAddress.getByName("SKY-20170224CAI" );
        System.out.println("计算机名称："+address1.getHostName() );
        System.out.println("主机IP地址："+address1.getHostAddress() );
        //根据IP地址获取InetAddress实例
        System.out.println("********************" );
        InetAddress address2=InetAddress.getByName("10.155.1.240" );
        System.out.println("计算机名称："+address2.getHostName() );
        System.out.println("主机IP地址："+address2.getHostAddress() );
    }
}
