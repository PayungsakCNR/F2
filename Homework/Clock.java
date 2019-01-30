public class Clock{
	private int h;
	private int m;
	private int state;

	public Clock(int hour,int minute){
		h = hour;
		m = minute;
		state = 0;
	}

	public void pressUp(){
		if(state == 1){
			h++;
		}
		else if(state == 2){
			m++;
		}
	}
	public void pressDown(){
		if(state == 1){
			h--;
		}
		else if(state == 2){
			m--;
		}
	}
	public void pressCenter(boolean longpress){
		if(longpress){
			if(state == 0){
				state = 1;
			}
			else{
				state = 0;
				printTime();
			}
		}
		else{
			switch(state){
				case 1:
					state = 2; break;
				case 2:
					state = 1; break; 
			}
		}
	}
	public void printTime(){
		System.out.println(h + ":" + m);
	}
}