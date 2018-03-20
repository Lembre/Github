package practices;

public class Mydogs extends Myanimal {
    public  Mydogs(){
        super("dsa" );//Zhe
        System.out.println("子类执行了" );
        super.eat();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void method(){
        System.out.println(super.age);
    }
    public static void main(String[] args) {
        String[] name1= {"dsa","dsa" ,"dsa"
        } ;
        String[] name2= {"dsa", "dsa", "dsa" };
        Myanimal ma= new Myanimal("dsa" );
        System.out.println(ma.age);
        Mydogs md= new Mydogs();
        md.age= 30;
        System.out.println(md.age);
        md.name= "AAA" ;
        md.eat();
        md.method();
        System.out.println(md );
        System.out.println(name1);
        System.out.println(name2);
    }
}
//子类调用过程中必须条用其父类的构造方法，如果子类的构造方法没有显示调用父类构造方法，系统默认调用父类的无参数构造方法
//如果父类没有无参数的构造方法，那么报错；如果显示调用父类构造方法，super必须放在子类构造方法第一行。父类的构造方法也会被调用
//并且是父类构造方法先调用子类构造方法会默认调用父类的 无参的构造方法

