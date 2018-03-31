package practices;

import java.util.Arrays;

public class Mystring {
    public static void main(String[] args) {
        String str = "学习 Java 编程" ;
        System.out.println("字符串长度"+str.length());
        char c= '编';
        System.out.println("字符编的位置" +str.indexOf(c));
        System.out.println("字符串Java的位置"+str.indexOf("Java" ) );
        System.out.println("字符串imooc的位置" +str.indexOf("imooc" ));
        String[] arr= str.split(" " );//按空格拆分成字符串
        System.out.println("把子字符串变成数组" + Arrays.toString(arr));
        System.out.println(arr[0]);
        System.out.println(arr[0] instanceof String);
        System.out.println("截取子字符串" +str.substring(3,7));
        System.out.println("************************************" );
        String str1= "学习 Java 课程";
        System.out.println("转换成小写字符"+str1.toLowerCase() );
        System.out.println("获取下标为1的字符"+str1.charAt(1));
        byte[] b= str1.getBytes();
        for (int i= 0;i<b.length-1;i++) {
            System.out.print(b[i]+" " );
        }



    }
}
