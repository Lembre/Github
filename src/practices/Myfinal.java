package practices;

/*
public class Myfinal {
    final public int b= 3;
    static public final int c= 2;
    public Myfinal(){
        final int a= 5;
        //a= 3;
        System.out.println("调用无参构造方法" +a);
        System.out.println(b);
    }
    public void show(){
        System.out.println("show message" );
    }
    public static void main(String[] args) {

        //a= 5;
        final Myfinal t;
        t= new Myfinal();
        //t= new Test();
        Myfinal test1= new Myfinal();
        t.show();
        //System.out.println(b);
        System.out.println(*/
/*Myfinal.*//*
c);
        System.out.println(3);
    }
}
*/
/*
当类被修饰成final的时候，表示类不能够被继承。final修饰基本类型变量，表示该变量只有一次赋值机会
行进行了赋值，就不可以再进行赋值了.变成常量。当方法被修饰成final的时候，表示方法不能够被重写
声明并且初始化时，final修饰属性，属性不能被修改，包括构造方法和main函数；只声明不初始化会报错，除非在构造方法中初始化*/
public  class Myfinal{
    public final int a= 3;
    /*public  Myfinal(){
        //a = 3;
    }*/

    public static void main(String[] args) {
        Myfinal mf= new Myfinal();
        System.out.println(mf.a);
    }
}