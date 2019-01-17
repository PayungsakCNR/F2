public class Adder() {

    private int sum;
    private int num_mem,num_new;
    
    public Adder(){
        sum = num_mem + num_new;
    }
    
    public int getSum() {
        return sum;
    }
    
    public int reset() {
        sum = 0;
    }
    


}
