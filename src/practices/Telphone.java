package practices;

public class Telphone extends Mytelphone {
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

    }
}
