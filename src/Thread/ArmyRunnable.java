package Thread;
//军队线程，模拟作战双方的行为
public class ArmyRunnable implements Runnable{
    //volatile保证了线程可以正确的读取其他线程写入的值
    //可见性ref JMM,happens-before原则
    volatile boolean keepRunning= true;//使得下达keeprunning之后，一个线程包含的业务能够被完整的执行

    @Override
    public void run() {
        while (keepRunning){
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"进攻对方"+i+"次"  );
                Thread.yield();//暂停当前正在执行的线程对象，并执行其他线程。
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗" );
    }
}
//线程其实就是用户自己定义的任务，所以才需要覆写run方法，或者用runnable初始化线程。
class Stage extends Thread{//舞台线程用于调度、隋军、农民军两个线程
    public void run(){
        System.out.println("欢迎收看隋唐演义" );
        try {
            Thread.sleep(2000);//在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），
            // 此操作受到系统计时器和调度程序精度和准确性的影响。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        System.out.println("大幕徐徐拉开 ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋朝末年，随军与农民军杀得昏天黑地" );
        //新建线程
        ArmyRunnable armyTaskOfSuiDynasty= new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt= new ArmyRunnable();
        //使用Runnable接口实现（激活）线程,创建线程的另一种方法是声明实现 Runnable 接口的类。该类然后实现 run 方法。
        // 然后可以分配该类的实例，在创建 Thread 时作为一个参数来传递并启动
        Thread armyOfSuiDynasty= new Thread(armyTaskOfSuiDynasty,"隋军" );
        Thread armyOfRevolt= new Thread(armyTaskOfRevolt,"农民起义军" );
        //启动线程
        /*armyOfSuiDynasty.setPriority(Thread.MAX_PRIORITY);
        armyOfRevolt.setPriority(Thread.MIN_PRIORITY);*/
        armyOfSuiDynasty.start();
        armyOfRevolt.start();
        //线程休眠
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       /* armyTaskOfSuiDynasty.keepRunning=false;
        armyTaskOfRevolt.keepRunning = false;
        try {
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //停止线程的正确方法
        armyTaskOfSuiDynasty.keepRunning= false;
        armyTaskOfRevolt.keepRunning= false;
        //停止线程的错误方法,已经移除，对数据和业务有害
        /*armyTaskOfSuiDynasty.stop;
        armyTaskOfRevolt.stop;*/
        System.out.println("正当双方激战正酣，半路杀出个程咬金" );
        //创建并启动一个线程
        Thread MrThread= new KeyPersonThread();
        MrThread.setName("程咬金" );
        System.out.println("程咬金的理想就是结束战争，使得百姓安居乐业" );
        //休眠舞台线程
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MrThread.start();
        //所有线程等待该线程完成
        try {
            MrThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束，程咬金实现了他的理想" );
        System.out.println("谢谢观看" );
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}

class KeyPersonThread extends Thread{
        public void run(){
            System.out.println(Thread.currentThread().getName()+"开始了战斗"  );
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"左突右杀，攻击随军" );
            }
            System.out.println(Thread.currentThread().getName()+"结束了战斗"  );
        }
        }
//Join就是加入进来，让别人其他线程等待自己结束后在执行
//yeald就是礼让，自己先暂停，让其他线程先执行，等其他线程执行完之后，自己再执行
//有的像C语句，嵌入式，单片机，DSP，微机原理里面的中断操作，保护线程，然后执行其他的
// ，等执行完后，返回现场，恢复现场，DMA，OS操作系统，多进程，多线程
