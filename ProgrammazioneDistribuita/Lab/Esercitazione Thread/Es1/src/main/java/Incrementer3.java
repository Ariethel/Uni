public class Incrementer3 {
    public static void main(String[] args) {
        //Versione con 4 Thread senza verificare race condition
        Contatore cont = new Contatore();
        MyThread[] threads = new MyThread[4];

        //passo un solo contatore a tutti i thread
        for (int i = 0; i < 4; i++){
            threads[i] = new MyThread(cont);
        }

        //Creo i 4 thread perche' uso runnable e non Thread
        Thread[] t = new Thread[4];
        for (int i = 0; i < 4; i++){
            t[i] = new Thread(threads[i]);
        }

        //Avvio i 4 thread
        for (int i = 0; i < 4; i++){
            t[i].start();
        }


        // Mettendo il metodo increment come synchronized e facendo la join nel main per i 4 thread in modo
        // da attendere la fine di tutti i thread prima di stampare, il contatore varra' sempre 40000
        for (int i = 0; i < 4; i++){
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Il contatore con thread vale: " + cont.getCount());

    }
}
