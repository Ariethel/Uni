public class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            this.count++;
        }

    }

    public int getCount(){
        return this.count;
    }

    public void start() {
        for (int i = 0; i < 10000; i++){
            this.count++;
        }
        this.id += 1;
    }

    public int getId(){
        return id;
    }
    private int count = 0;
    private static int id = 0;

}
