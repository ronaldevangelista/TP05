public class Count extends Thread{
    int max = 0;
    Screen screen = new Screen("Teste Thread", 480, 640, 250, 250);
    public void setValue(int max){
        this.max = max;
    }
    public Count(){
    }
    public static void main(String[] args) {
        new Count();
    }

    public boolean addInfo(String i){
        Thread c = Thread.currentThread();

        if(c.getName().equals("Thread-1")){
            screen.leftList.add(i);
        } else {
            screen.rightList.add(i);
        }
        return false;
    }

    public void run(){
        for (int i = 0; i <= max; i++) {
            this.addInfo(i + "");
        }
    }

    
}