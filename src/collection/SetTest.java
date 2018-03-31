package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {
    private List<course> coursesToSelect;
    public SetTest(){
        this.coursesToSelect= new ArrayList<course>();
    }
    public void testAdd(){
        //用于往coursesToSelect中添加备选课程
        course cr1= new course(1,"数据结构" );
        coursesToSelect.add(cr1);
        //System.out.println("添加了一个课程：" );
        course temp= (course)coursesToSelect.get(0);//类型强转，
        //System.out.println(temp.getId()+temp.getName());

        course cr2= new course(2,"C语言" );
        coursesToSelect.add(0,cr2);
        //System.out.println("添加了一个课程：" );
        course temp2= (course) coursesToSelect.get(0);
        //System.out.println(temp2.getId()+temp2.getName());
        //System.out.println("*******************" );

        course[] cs= {new course(3,"Java高级程序设计" ),new course(4,"毛概" )};
        //为什么course可以定义数组？因为万物皆对象，要特别注意类型，对象，引用的含义。
        coursesToSelect.addAll(Arrays.asList(cs));
       course temp3= (course)coursesToSelect.get(2);//注意在中间位置插入数据后，要修改index
        course temp4= (course)coursesToSelect.get(3);
       // System.out.println(temp3.getId()+temp3.getName());
       // System.out.println(temp4.getId()+temp4.getName());
    }
    public void testForEach(){
        System.out.println("********foreach访问*************" );
        for(Object obj:coursesToSelect){//一个元素存入到集合中，是被当做Object的,所以取出来就是Object类型
            course cr= (course) obj;
            System.out.println(cr.getId()+cr.getName());
        }
    }

    public static void main(String[] args) {
        SetTest st= new SetTest();
        st.testAdd();
        st.testForEach();
        //创建一个学生对象：
        student student1=  new student(1,"小明" );
        System.out.println("欢迎" +student1.getName()+"来选课:" );
        Scanner sc= new Scanner(System.in);
        for (int i = 0; i <3 ; i++) {
            System.out.println("请输入课程ID：" );
            int couseId= sc.nextInt();
            for(course cr:st.coursesToSelect){
                if (new Integer(cr.getId()).equals(couseId)){
                    student1.courses.add(cr);
                }
            }
        }
        for(course cr:student1.courses){
            System.out.println("选择了课程" +cr.getId()+cr.getName());
        }
    }
}
