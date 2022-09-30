import org.w3c.dom.css.Counter;

public class Main {
    public static void main(String[] args) {
        Contatore count = new Contatore();
        Incrementer inc = new Incrementer();
        //Versione senza thread
        for(int i = 0; i < 40000; i++){
            inc.increment(count);
            count.setCount(inc.retCount());
        }
        System.out.println("Il valore di count e': " + count.getCount());

        //Versione con 4 thread (2)
        int sum = 0;
        for (int i = 0; i < 4; i++){
            MyThread threads = new MyThread();
            threads.start();
            System.out.println("Thread " + threads.getId() + "ha contato: " +threads.getCount());
            sum+=threads.getCount();
        }
        System.out.println("La somma dei count e': " + sum);

        //Versione senza race condition

    }
}