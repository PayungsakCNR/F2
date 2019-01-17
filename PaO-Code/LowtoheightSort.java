import java.util.Arrays;
import java.util.Scanner;

public class LowtoheightSort{
	public static void main(String args[]){
		Integer[] number = new Integer[] {23,4,22,18,9,39,40,21,60,400};

		Arrays.sort(number);

		System.out.print(Arrays.toString(number) + ", ");
		System.out.print("\n");
	}
}