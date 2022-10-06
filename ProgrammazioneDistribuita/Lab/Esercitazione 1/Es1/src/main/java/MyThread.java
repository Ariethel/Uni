public class MyThread implements Runnable{
    public void run() {
        for (int i = 0; i < 10000; i++){
            inc.increment(cont);
           // System.out.println("Sono il thread: " + Thread.currentThread().getId());
        }
    }

    public int getCount(){
        return cont.getCount();
    }


    private static Contatore cont = new Contatore();
    private Incrementer inc = new Incrementer();

}
