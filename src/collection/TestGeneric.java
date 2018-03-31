package collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    List<course> cs;
    public TestGeneric(){
        this.cs= new ArrayList<>();
    }

    //测试添加
    public void textAdd(){
        course cr= new course(1,"大学英语" );
        cs.add(cr);//泛型集合中不能添加泛型规定的以外的东西。否则会把报错
        //cs.add("sfsafsaf" );//error规定了泛型
        System.out.println("添加了英语课程" );
    }
    public void testForEach(){
        for(course cr:cs){//这里不需要再次Object
            System.out.println(cr.getId()+cr.getName());//引用 对象，引用 对象！！！
        }
    }
    //测试泛型集合可以添加泛型的子类实例
    public void testChild(){
        Childcourse ccr= new Childcourse(2,"大学语文" );
        cs.add(ccr);//不报错
        System.out.println("添加了语文课程" );
    }
    //测试泛型能不能使用基本类型
    public void testBasicType(){
       // List<int> a= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        list.add(1);
        System.out.println("li11" +list.get(0));
    }

    public static void main(String[] args) {
        TestGeneric tg= new TestGeneric();
        tg.textAdd();
        tg.testForEach();
        tg.testChild();
        tg.testForEach();
        tg.testBasicType();

    }//此外泛型集合中的限定类型，不能使用基本数据类型，可以通过使用包装类限定允许存入的基本数据类型。

}
