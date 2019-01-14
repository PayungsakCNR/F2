import java.io.*;

public class TestPrintnumber{
	public static void main(String args[]){
		PrintNumber  p1 = new PrintNumber();
		PrintNumber  p2 = new PrintNumber();
		int num1 = 100,num2 = 200,i,j;
		
		System.out.println("Before reset num1 " + num1 + "\n");
		System.out.println("Before reset num2 " + num2 + "\n");
		num1 = p1.reset(num1); //reset num1 to 0
		num2 = p2.reset(num2); //reset num2 to 0
		System.out.println("After reset num1 " + num1 + "\n");
		System.out.println("After reset num2 " + num2 + "\n");

		//print number
		for(i = num1; i<5;  i = i + p1.incress(num1)){
			for(j = num2; j<10;  j = j + p2.incress(num2)){
				System.out.print (j+p2.incress(num2)  + ", ");
		}
		System.out.println("\n");		
	}
	System.out.println("\n");
	}
}