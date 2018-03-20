package practices;

public class Mythis {
    private float screen;
    private float cpu;
    private float men;

    public float getScreen() {
        return screen;
    }

    public void setScreen(float screen) {
        this.screen = screen;
        this.showMessage();
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public float getMen() {
        return men;
    }

    public void setMen(float men) {
        this.men = men;
    }
    public void showMessage(){
        System.out.println("成功赋值" );
    }

    public static void main(String[] args) {
        Mythis mt= new Mythis();
        mt.setScreen(2.1f);
        System.out.println(mt.getScreen());
    }
}
