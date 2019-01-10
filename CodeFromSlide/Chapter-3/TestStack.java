import java.io.*;

public class TestStack{
	public static void main(String args[]){
		Stack stk1 = new Stack(10);

		stk1.push(42);
		stk1.push(17);
		stk1.push(50);

		System.out.println("Top value is " + stk1.topOf());
	}
}