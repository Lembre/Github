package collection;

import java.util.HashSet;
import java.util.Set;

public class student {
    public Set<course> courses;//一个接口类型的引用指向了一个实现给接口的对象，这是java中的一种多态现象
    //java中的接口不能被实例化，但是可以通过接口引用指向一个对象，这样通过接口来调用方法可以屏蔽掉具体的方法的实现，
    //这是在JAVA编程中经常用到的接口回调，也就是经常说的面向接口的编程
    //接口是不能实例化成对象的，但是可以声明接口引用，而把这个引用赋一个对象，这个对象和接口之间是直接或间接实现的关系。
    private int id;
    private String name;

    public Set getCourses() {
        return courses;
    }

    public void setCourses(Set courses) {
        this.courses = courses;
    }

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
    public student(int id,String name){
        this.id= id;
        this.name= name;
        this.courses= new HashSet<course>();
    }

}
