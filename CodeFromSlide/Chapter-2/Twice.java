import javax.swing.JOptionPane;

public class Twice{
	public static void main(String[] args) {
		String number;
		int num;

		number = JOptionPane.showInputDialog("Enter number integer:");

		//String to Int
		num = Integer.parseInt(number);

		num = num*2;

		JOptionPane.showMessageDialog(null,num,"Output:",JOptionPane.INFORMATION_MESSAGE);
	}
}