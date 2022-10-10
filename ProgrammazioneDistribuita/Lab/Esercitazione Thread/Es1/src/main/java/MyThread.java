public class MyThread implements Runnable{

    public MyThread(Contatore cont){
        this.cont = cont;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            cont.inc();
        }
    }

    public int getCount(){
        return cont.getCount();
    }


    private static Contatore cont;

}
