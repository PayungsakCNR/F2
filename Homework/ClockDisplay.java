public class ClockDisplay{
	private NumberDisplay hours;
	private NumberDisplay minutes;
	private String currTimesString;

	public ClockDisplay(){
		hours = new NumberDisplay(24);
		minutes = new NumberDisplay(60);
		setTimeString();
	}

	private void setTimeString(){
		currTimesString = hours.getDisplayVal() + ":" + minutes.getDisplayVal();
	}

	public void setTime(int hour, int minute){
		hours.setVal(hour);
		minutes.setVal(minute);
		setTimeString();
	}

	public String getTime(){
		return currTimesString;
	}

	
}