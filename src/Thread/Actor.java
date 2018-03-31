package Thread;

public class Actor extends Thread {
    public void run(){
        System.out.println(getName()+"是一个演员" );
        int count= 0;
        boolean keepRunning= true;
        while (keepRunning== true){
        System.out.println(getName()+"登台演出"+(++count)+"次" );
        if(count== 40){
            keepRunning= false;
        }
        if(count%10==0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
        System.out.println(getName()+"演出结束" );
    }

    public static void main(String[] args) {
        Thread actor= new Actor();//父类引用指向子类对象
        actor.setName("Mr.Thread" );
        actor.start();
        Thread actressThread= new Thread(new Actress(),"Ms.Runnable" );
        actressThread.start();
    }
}

class Actress implements Runnable{
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName()+"是一个演员" );
            int count= 0;
            boolean keepRunning= true;
            while (keepRunning== true){
                System.out.println(Thread.currentThread().getName()+"登台演出"+(++count)+"次" );
                if(count== 40){
                    keepRunning= false;
                }
                if(count%10==0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()+"演出结束" );
        }//单核为基础讲的？？
}
