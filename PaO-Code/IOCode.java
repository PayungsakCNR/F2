import java.util.Scanner;

public class IOCode {
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	
    	System.out.print("Enter an integer: ");
    	int number = input.nextInt();
    	System.out.println("You entered " + number);
    }
}