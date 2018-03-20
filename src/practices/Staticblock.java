package practices;

import javax.net.ssl.SSLContext;

public class Staticblock {
    int num1;
    int num2;
    int num4;
    static int num5;
    static int num3;
    public Staticblock(){
        num1= 30;
        num5= 70;
        System.out.println("通过构造方法赋值" );
    }
    {
        num2= 40;
        System.out.println("通过初始化块来赋值" );
    }
    static {
        num3= 50;
        /*num4= 60;error*/
        System.out.println("通过静态初始化块来赋值" );
    }

    public static void main(String[] args) {
        Staticblock sb1= new Staticblock();
        System.out.println(sb1.num1);
        System.out.println(sb1.num2);
        System.out.println(Staticblock.num3);
        Staticblock sb2= new Staticblock();
    }
}
/*静态初始化块只在类加载时执行，且只会执行一次，同时静态初始化块只能给静态变量赋值，不能初始化普通的成员变量。*/
/*由于静态初始化块只在类加载时执行一次，所以当再次创建对象 sb2 时并未执行静态初始化块。*/
//这也说明程序是先初始化在运行。