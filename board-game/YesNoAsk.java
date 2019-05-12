/* Yes No Dialog Test by PaOv6. */
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class YesNoAsk {
  public static void main(String[] args) {
    int val = 0;
    JDialog.setDefaultLookAndFeelDecorated(true);
    int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION) {
      System.out.println("No button clicked");
    } else if (response == JOptionPane.YES_OPTION) {
      System.out.println("Yes button clicked");
      val = 1;
    } else if (response == JOptionPane.CLOSED_OPTION) {
      System.out.println("JOptionPane closed");
    }
    System.out.println("Final Val = " + val);
  }
}