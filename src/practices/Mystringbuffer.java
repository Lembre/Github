package practices;

public class Mystringbuffer {
    public static void main(String[] args) {
        String str5= new String("fds");

        StringBuilder str1= new StringBuilder();
        StringBuilder str2= new StringBuilder("imooc" );
        System.out.println(str2);
        str2.append(520);
        str2.append("welcome" );
        System.out.println(str2.indexOf("moo" ));
        System.out.println(str2);
        System.out.println("******" );
        System.out.println(str2.length());
        str2.insert(3,"!" );
        //String str3= str2.toString();
        System.out.println(str2);




    }//StringBuffer 是线程安全的，而 StringBuilder 则没有实现线程安全功能，所以性能略高。因此一般情况下，
    // 如果需要创建一个内容可变的字符串对象，应优先考虑使用 StringBuilder 类。

}
