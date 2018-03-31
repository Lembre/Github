package practices;

public class Myrectangle extends Myshape implements Myinterface{
    @Override
    public void perimeter() {
        System.out.println("长乘以宽乘二" );
    }

    @Override
    public void area() {
        System.out.println("长乘以宽");
    }

    @Override
    public void Jiekou() {
        System.out.println("矩形类继承了shape类还实现了接口" );
    }
}
