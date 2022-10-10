public class Incrementer2 {
    public static void main(String[] args) {
        //Versione con 4 Thread senza verificare race condition
        Contatore cont = new Contatore();
        MyThread[] threads = new MyThread[4];

        //passo un solo contatore a tutti i thread
        for (int i = 0; i < 4; i++){
            threads[i] = new MyThread(cont);
        }


        //Essendoci race condition, non riuscira' quasi mai a contare 40000
        for (int i = 0; i < 4; i++){
            Thread t = new Thread(threads[i]);
            t.start();
        }

        System.out.println("Il contatore con thread vale: " + cont.getCount());

    }
}
