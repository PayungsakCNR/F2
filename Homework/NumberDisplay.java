public class NumberDisplay{
	private int curVal;
	private int maxVal;

	public NumberDisplay(int max){
		maxVal = max;
		curVal = 0;
	}

	public void setValue(int newVal){
		if((newVal >= 0) && (newVal < maxVal))
			curVal = newVal;
	}

	public int getVal(){
		return curVal;
	}

	public String getDisplayVal(){
		if(curVal < 10)
			return "0" + curVal;
		else
			return "" + curVal;
	}

	public void increment(){
		curVal = (curVal + 1) % maxVal;
	}
}