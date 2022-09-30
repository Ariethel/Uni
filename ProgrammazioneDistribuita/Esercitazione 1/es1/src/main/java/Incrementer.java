public class Incrementer {
    public void Incrementer(){
        i = 0;
    }

    public void increment(Contatore count){
        i = count.getCount() + 1;
    }

    public int retCount(){
        return i;
    }

    private int i;
}
