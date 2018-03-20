package practices;
/*
1. 内部类提供了更好的封装，可以把内部类隐藏在外部类之内，不允许同一个包中的其他类访问该类
2. 内部类的方法可以直接访问外部类的所有数据，包括私有的数据
3. 内部类所实现的功能使用外部类同样可以实现，只是有时使用内部类更方便
*/
/*public class Myinnerclass {
    public class Inner{
        public void show(){
            System.out.println("我是内部类" );
        }
    }

    public static void main(String[] args) {
        Myinnerclass mic= new Myinnerclass();
        Inner in= mic.new Inner();//若外部类对象不存在，那么内部类的对象就没有存在意义了
        in.show();
    }
}*/

//***************************************成员内部类：*********************************************************
/*
Inner 类定义在 Outer 类的内部，相当于 Outer 类的一个成员变量的位置，Inner 类可以使用任意访问控制符
如 public 、 protected 、 private 等
Inner 类中定义的 test() 方法可以直接访问 Outer 类中的数据，而不受访问控制符的影响，如直接访问 Outer 类中的私有属性a
定义了成员内部类后，必须使用外部类对象来创建内部类对象，而不能直接去 new 一个内部类对象 即：内部类 对象名 = 外部类对象.new 内部类( );
如果外部类和内部类具有相同的成员变量或方法，内部类默认访问自己的成员变量或方法，如果要访问外部类的成员变量，可以使用 this 关键字*/
/*public class Myinnerclass{
    private int age= 28;
    private String name = "imooc" ;
    public class Inner{
        String name= "慕课网" ;
        public void show(){
            System.out.println("我是内部类" );
            System.out.println("外部类的name是" + Myinnerclass.this.name);
            System.out.println("内部类的name是"+name);
            System.out.println("外部类中的age是"+age );
        }
    }
    public void show(){
        Myinnerclass mic= new Myinnerclass();
        Inner i= mic.new Inner();
        System.out.println("***外部类成员方法调用内部类成员方法***" );
        i.show();
    }

    public static void main(String[] args) {
        Myinnerclass mic= new Myinnerclass();
        Inner i= mic.new Inner();
        i.show();
        mic.show();
    }
}*/

//***************************************静态内部类：**********************************************************
/*
1、静态内部类不能直接访问外部类的非静态成员，但可以通过 new 外部类().成员 的方式访问
2、如果外部类的静态成员与内部类的成员名称相同，可通过“类名.静态成员”访问外部类的静态成员；如果外部类的静态成员与内部类的成员名称不相同
则可通过“成员名”直接调用外部类的静态成员
3、创建静态内部类的对象时，不需要外部类的对象，可以直接创建 内部类 对象名= new 内部类();*/
/*
public class Myinnerclass{
    private int a= 99;
    static int b= 1;
    static int c=3;
    public static class Inner{
        int b= 2;
        public void show(){
            System.out.println("访问外部类中的非静态成员"+new Myinnerclass().a );
            System.out.println("访问外部类中重名的静态成员"+Myinnerclass.b);
            System.out.println("访问外部类中不重名的静态成员"+c);
        }
    }
    public void show(){
        Inner i= new Inner();
        i.show();
    }
    public static void main(String[] args) {
        //Myinnerclass mis= new Myinnerclass();
        Inner i= new Inner();
        i.show();
    }
}
*/
//***************************************方法内部类：**********************************************************
/*
方法内部类就是内部类定义在外部类的方法中，方法内部类只在该方法的内部可见，即只在该方法内可以使用。
由于方法内部类不能在外部类的方法以外的地方使用，因此方法内部类不能使用访问控制符和 static 修饰符*/
public class Myinnerclass{
    public void show(){
        final int a= 2;
        int b= 13;
        class Inner{
            int c= 2;
            public void print(){
                System.out.println("访问外部类方法的常量a:"+a );
                System.out.println("访问内部类的变量c:"+c);
            }
        }
    Inner i= new Inner();
         i.print();
    }

    public static void main(String[] args) {
        Myinnerclass mis=new Myinnerclass();
        mis.show();
    }
}
