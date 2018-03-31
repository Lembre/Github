package practices;

public class Telphone extends Mytelphone {
    public Telphone(){

    }
    public Telphone(float screen,float cpu,float mem){
        super(screen, cpu,mem);
    }
    public static void main(String[] args) {
        //Mytelphone mp= new Mytelphone();
        Mytelphone mp1= new Mytelphone(1.2f,3.0f,2.0f);
        Mytelphone mp2= new Mytelphone(1.2f,3.0f,2.0f);
        Telphone mp= new Telphone(1.2f,3.0f,2.0f);
        System.out.println(mp.equals(mp1));
        System.out.println(mp1);
        System.out.println(mp2);
        if(mp1.equals(mp2)){
            System.out.println("两个对象相同" );
        }else{
            System.out.println("两个对象值不相同"  );
        }
        Telphone a= new Telphone();
        Mytelphone b= a;
        //Telephone c= b;确实可行，但是编译器认为不可行，会报错，所以要向下面一样强制转换
        Telphone c= (Telphone)b;
        System.out.println(b instanceof Telphone);//验证强制转换后的类型。
        System.out.println(b instanceof Mytelphone);//所以可以使用instanceof来避免类型转换的安全问题。
        //但是上面的强制转换存在风险，比如下面的
        //Ipad ip= (Ipad)b;报错

    }
}
