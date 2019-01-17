public class Adder{
	private int val;

	public Adder(){
		val = 0;
	}
	public void add(int v){
		val += v;
	}
	public int getVal(){
		return val;
	}
	public void reset(){
		val = 0;
	}
}