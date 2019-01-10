import java.io.*;

public class TestCalculator{
	public static void main(String args[]){
		Calculator cal1 = new Calculator();
		int a=10,b=20;
		System.out.println("Sum  is " + cal1.sum(a,b) + "\n");
		System.out.println("Different  is " + cal1.minus(a,b) + "\n");
	}
}