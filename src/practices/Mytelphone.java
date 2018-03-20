package practices;

import java.util.Objects;

public class Mytelphone {
    float screen;
    float cpu;
    float mem;

    public float getScreen() {
        return screen;
    }

    public void setScreen(float screen) {
        this.screen = screen;
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public float getMem() {
        return mem;
    }

    public void setMem(float mem) {
        this.mem = mem;
    }

    public Mytelphone(float screen,float cpu,float mem){
        this.screen= screen;
        this.cpu= cpu;
        this.mem= mem;
    }

    @Override
    public boolean equals(Object o) {//在重写之前，equals()比较引用的地址是否相同,重写是为了只要值相等，就认为是同一个对象
        if (this == o) return true;//在如果指向同一个地址，那么对象“绝对相同”
        if (o == null || getClass() != o.getClass()) return false;//如果传入的是空指针或类对象不同，那么绝对不同；
        //Mytelphone that = (Mytelphone) o;类对象：一个类的所有对象对应同一个类对象。子类也不行
        return /*Float.compare(that.screen, screen) == 0 &&
                Float.compare(that.cpu, cpu) == 0 &&
                Float.compare(that.mem, mem) == 0;//属性值是否相同*/
        this.screen==screen &&this.cpu== cpu&&this.mem==  mem;
    }
//绝对相同放一种条件里判断，绝对不同方拎一个条件判断，剩下的由他的值判断。要理解他们之间的含义与包不包含关系。

}
