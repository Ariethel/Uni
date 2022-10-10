public class Incrementer1 {
    public static void main(String[] args) {
        Contatore cont = new Contatore();
        //Versione senza Thread
        for (int i = 0 ; i < 40000; i++){
            cont.inc();
        }
        System.out.println("Il contatore senza thread vale: " + cont.getCount());



    }
}