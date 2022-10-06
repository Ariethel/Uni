public class Main {
    public static void main(String[] args) {
        Contatore cont = new Contatore();
        Incrementer inc = new Incrementer();
        //Versione senza Thread
        for (int i = 0 ; i < 40000; i++){
            inc.increment(cont);
        }
        System.out.println("Il contatore senza thread vale: " + cont.getCount());

        //Versione con 4 Thread senza verificare race condition
        cont.reset();
        for (int i = 0; i < 4; i++){
            MyThread t = new MyThread();
            Thread obj = new Thread(t);
            obj.start();
        }

    }
}