package collection;

public class course {
    private int id;
    private String name;
    /*public course(){//已经定义了有参数构造方法，而子类继承又必须调用父类构造方法，防止出错，所以要加默认构造方法。

    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public course(int id,String name){
        this.id= id;
        this.name= name;
    }
}
