public class CounterTest{
	public static void main(String args[]){
		Counter c = new Counter();
		int i;
		for(i=0; i<5; i++){
			while(c.getVal() < 10){
				c.inc();
				System.out.print(c.getVal() + ",");
			}
			System.out.print("\n");
			c.reset();
		}
	}
}