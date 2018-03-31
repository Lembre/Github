package practices;

import java.sql.SQLOutput;

public class Myexception {
    public void divide(int a,int b)throws Exception{
        if(b== 0) {
            throw new Exception("除数不能为零" );//自定义异常，throws出现在方法声明上，而throw通常都出现在方法体内。
        }
        else{
            System.out.println("俩数相除结果为：" +a/b);
        }
    }
    public void compute(){
        try{
            divide(5,0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void test1() throws Myselfexception{//使用throw必须抛出异常，这里必须throws Myselfexception
        throw new Myselfexception("喝车别开酒" );
    }
    public void test2(){
        try{
            test1();
        }
        catch(Myselfexception e){
            RuntimeException re= new RuntimeException(/*"别喝酒" */e);//异常抛出再被接受再被以量一种方式抛出
            throw re;
        }
    }
    public static void main(String[] args) {
        Myexception me= new Myexception();
        me.compute();
        System.out.println("**************************" );
        try{
            me.test2();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
