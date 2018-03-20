package practices;

public class Myanimal extends Object {
    public int age= 10;
    public String name;

    @Override
    public String toString() {
        return "Myanimal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Myanimal(String name){
        this.name= name;
        /*System.out.println("父类执行了" );
        age= 20;//逻辑能力，age应该放在这里！！*/
    }
    public void eat(){
        System.out.println("动物会吃饭" );
    }

}
