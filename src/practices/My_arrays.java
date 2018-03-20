package practices;

import java.util.Arrays;

public class My_arrays {

    //完成 main 方法
    public static void main(String[] args) {
        My_arrays arr= new My_arrays();
        int[] a= {89,-23,64,91,119,52};
        System.out.println("考试前三名成绩为：" );
        arr.mysort(a);
    }
    //定义方法完成成绩排序并输出前三名的功能
    public void mysort(int[] a){
        Arrays.sort(a);
        int grade= 0;
        /*for(int i=a.length-1;i>= 0;i--){
            if(a[i] <0|a[i] >100)
            {
                grade++;
                continue;
            }
            if(grade>3){
                break;
            }
        }
        System.out.println(a[a.length-1]);
        System.out.println( a[a.length-2]);
        System.out.println(a[a.length-3]);*/
        for (int i = a.length-1;i>=0&&grade<3;i--) {
            if (a[i]<0|a[i]>100){
                continue;
            }else
            {
                grade++;
                System.out.println(a[i]);
            }

        }
    }
}