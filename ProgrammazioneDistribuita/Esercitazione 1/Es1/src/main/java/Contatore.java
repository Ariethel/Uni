public class Contatore {
    public void Contatore(){
        this.count = 0;
    }

    public void addCount(){
        this.count += 1;
    }

    public int getCount(){
        return count;
    }

    public void reset(){
        count = 0;
    }
    private int count;
}
