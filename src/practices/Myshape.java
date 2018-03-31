package practices;

public abstract  class Myshape {
    public abstract void perimeter();
    public abstract void area();

    public static void main(String[] args) {
        Myshape m1= new Myrectangle();
        m1.area();
        Myshape m2= new Mycircle();
        m2.area();
        Myinterface mi= new Myrectangle();
        mi.Jiekou();//Myrectangle类实现了接口Myinterface，所以可以调用接口的方法
        Myinterface mi1= new Myotherinterface();
        mi1.Jiekou();//Myotherinterface类实现了接口Myinterface，所以可以调用接口的方法
        //Myinterface mi3= new Mycircle();Mycircle类未实现了接口Myinterface，所以可以调用接口的方法

        Myinterface mi2= new Myinterface() {
            int a = 3;
            //a = 2;接口中的变量系统自动加上public static final
            @Override
            public void Jiekou() {
                System.out.println("使用匿名内部类实现接口" );
            }
        };
        mi2.Jiekou();
        new Myinterface(){
            @Override
            public void Jiekou() {
                System.out.println("使用匿名内部类实现接口2" );
            }
        }.Jiekou();

}
}
