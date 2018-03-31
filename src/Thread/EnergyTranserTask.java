package Thread;
//生产者与消费者
public class EnergyTranserTask implements Runnable{
    //共享的能量世界
    private Energysystem energysystem;
    //能量转移的源能量盒子下标
    private int frombox;
    //每次单位转移的最大单元
    private double maxAmount;
    //最大休眠时间
    private int DELAY= 10;

    public EnergyTranserTask(Energysystem energysystem,int frombox,double maxAmount){
        this.energysystem= energysystem;
        this.frombox= frombox;
        this.maxAmount= maxAmount;
    }
    public void run(){
        try{
            while (true){
                int toBox= (int)(energysystem.getBoxAmount()*Math.random());
                double amount= maxAmount*Math.random();
                energysystem.tranfer(frombox,toBox,amount);
                Thread.sleep((int)(DELAY*Math.random()));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Energysystem {
    //能量存储的地方
    private final double[] energyBoxes;
    private final Object lockObj= new Object();
    public Energysystem(int n,double initialEnergy){
        energyBoxes= new double[n];
        for (int i = 0; i <energyBoxes.length ; i++) {
            energyBoxes[i]= initialEnergy;
        }
    }
    public void tranfer(int from,int to,double amount){
        synchronized (lockObj){//表示对块中内容进行互斥同步操作
       /* if(energyBoxes[from]<amount)
            return;//当转移的能量大于源能量是，不合理，移除*/
       while (energyBoxes[from]<amount){
           try {
               lockObj.wait();//避免申请锁，从而节约开销，不竞争CPU资源，提升系统性能
               //产生wait set
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        System.out.print(Thread.currentThread().getName());
        energyBoxes[from]-= amount;//小数部分两位，整数部分10位
        System.out.printf("从%d转移%10.2f单位能量得到%d",from,amount,to);
        energyBoxes[to]+= amount;
        System.out.printf("能量中和：%10.2f%n",getTotalEnergies() );
        //唤醒所有在lockObj对象上等待的线程
        lockObj.notifyAll();
        }
    }
    public double getTotalEnergies(){
        double sum= 0;
        for (double amount:energyBoxes){
            sum+= amount;
        }
        return sum;
    }
    //返回能量盒子长度
    public int getBoxAmount(){
        return energyBoxes.length;
    }
}
class EnergysystemTest{
    //将要构建的能量盒子中盒子的数量
    private static final int BOX_AMOUNT= 100;
    private static final double INITIAL_ENERGY= 1000;

    public static void main(String[] args) {
        Energysystem eng= new Energysystem(BOX_AMOUNT,INITIAL_ENERGY);
        for (int i = 0; i < BOX_AMOUNT; i++) {
            EnergyTranserTask task= new EnergyTranserTask(eng,i,INITIAL_ENERGY);
            Thread t= new Thread(task,"TransferThread"+i );
            t.start();
        }
    }
}
//创建线程有两种方式：继承Thread类和Runnable接口；继承Runnable接口是将Runnaleb作为参数传入Thread中来创建线程;用户
// 可以通过重写run方法来规定线程来做哪些事情，即任务；因为多个线程争抢cpu资源，可能会造成数据的破坏，
// 因此可通过线程锁即synchronized(中文意思：同步的)关键字配合wait方法来过滤掉不满足条件的线程，
// 使这些线程保持休眠状态知道被重新唤醒，而满足条件的线程继续执行
// ，执行完毕后，通过notify（）/notifyAll（）方法唤醒处于睡眠状态的线程，重新竞争资源，然后再次通过线程锁重新筛选，循环往复


