public class Counter {
	private int val;
	public Counter(){
		val = 0;
	}
	public int getVal(){
		return val;
	}
	public void inc(){
		val++;
	}
	public void reset(){
		val = 0;
	}
}