package practices;

public class My_static {
    static  String hobby= "imooc" ;
    static  int score1= 37;
    static  int score2= 39;
    int score3= 21;
     public static int sum(int a,int b,int c){
         return a+b+c;
     }
     public void print(){
         System.out.println(score1);
         System.out.println(score3);
     }
    public static void main(String[] args) {
        System.out.println(My_static.hobby);
        My_static ms= new My_static();
        System.out.println(ms.hobby);
        My_static.hobby= "慕课网" ;
        System.out.println(My_static.hobby);
        //System.out.println(ms.score3);error希望在静态方法中调用非静态变量，可以通过创建类的对象，然后通过对象来访问非静态变量。
        int allscore= My_static.sum(score1,score2,ms.score3);
        System.out.println("总分为"+allscore );
     }
}
/*1,静态方法中可以直接调用同类中的静态成员，但不能直接调用非静态成员
2,如果希望在静态方法中调用非静态变量，可以通过创建类的对象，然后通过对象来访问非静态变量。
3,在普通成员方法中，则可以直接访问同类的非静态变量和静态变量*/
