package practices;

public class Telephone {
    float screen;
    float cpu;
    float mem;
    public Telephone(float newscreen,float newcpu,float newmem){
        if (newscreen<3.5f){
            System.out.println("输入的数据有误" );
        }else{
            screen= newscreen;
        }
        cpu= newcpu;
        mem= newmem;
    }
    public String toString(){
        return "screen:"+screen+" cpu:"+cpu+" mem" +mem;
    }

    public static void main(String[] args) {
        //Telephone phone1=new Telephone();类中存在自定义构造方法，不会自动调用无参构造方法；报错
        Telephone phone2= new Telephone(1.2f,2.4f,2.0f);
        System.out.println(phone2.toString());
    }
}
