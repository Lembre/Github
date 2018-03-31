package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListText {
    //用于存放备选课程的List
    private List coursesToSelect;
    public ListText(){
        this.coursesToSelect= new ArrayList<>();
    }
    public void testAdd(){//用于往coursesToSelect中添加备选课程
        course cr1= new course(1,"数据结构" );
        coursesToSelect.add(cr1);
        System.out.println("添加了一个课程：" );
        course temp= (course)coursesToSelect.get(0);//类型强转，
        System.out.println(temp.getId()+temp.getName());

        course cr2= new course(2,"C语言" );
        coursesToSelect.add(0,cr2);
        System.out.println("添加了一个课程：" );
        course temp2= (course) coursesToSelect.get(0);
        System.out.println(temp2.getId()+temp2.getName());
        System.out.println("*******************" );

        course[] cs= {new course(3,"Java高级程序设计" ),new course(4,"毛概" )};
        //为什么course可以定义数组？因为万物皆对象，要特别注意类型，对象，引用的含义。
        coursesToSelect.addAll(Arrays.asList(cs));
        course temp3= (course)coursesToSelect.get(2);//注意在中间位置插入数据后，要修改index
        course temp4= (course)coursesToSelect.get(3);
        System.out.println(temp3.getId()+temp3.getName());
        System.out.println(temp4.getId()+temp4.getName());
    }
    //通过for循环取得List元素的方法
    public void testGet(){
        int size= coursesToSelect.size();
        System.out.println("***************有如下方法待选：**********" );
        for (int i = 0; i < size ;i++) {
            course cs=(course) coursesToSelect.get(i);
            System.out.println(cs.getId()+cs.getName());
        }
    }
    //通过迭代器来遍历List
    public void testIterator(){
        Iterator ia= coursesToSelect.iterator();//迭代器只是用来遍历集合中元素的，本身不具备任何存储元素的功能
        //即迭代器是依赖于某个集合存在的，本身不能独立的存在
        System.out.println("有如下课程可选（迭代器访问）" );
        while (ia.hasNext()){
            course cr= (course) ia.next();
            System.out.println(cr.getId()+cr.getName());
        }
    }
    //通过foreach来遍历元素：
    public void testForEach(){
        System.out.println("********foreach访问*************" );
        for(Object obj:coursesToSelect){//一个元素存入到集合中，是被当做Object的,所以取出来就是Object类型
            course cr= (course) obj;
            System.out.println(cr.getId()+cr.getName());
        }
    }
    //修改List中的元素：
    public void testModify(){
        coursesToSelect.set(2,new course(7,"高数" ));//修改第三个课程
    }
    //删除List中的方法
    public  void testDelete(){
        course cr= (course)coursesToSelect.get(2);
        coursesToSelect.remove(cr);
    }
    //直接使用index来删除一个元素
    public  void testDelete1(){
        coursesToSelect.remove(1);
        testForEach();
    }
    //使用数组来删除多个元素
    public  void testDelete2(){
        course[] cs= {(course)coursesToSelect.get(0),(course)coursesToSelect.get(1)};
        coursesToSelect.removeAll(Arrays.asList(cs));
        System.out.println("成功删除课程" );
        testForEach();
    }

    public static void main(String[] args) {
        ListText i= new ListText();
        i.testAdd();
        i.testGet();
        i.testForEach();
        i.testIterator();
        i.testModify();
        i.testIterator();
        i.testDelete();
        i.testForEach();
        i.testDelete1();
        i.testDelete2();
    }
}
