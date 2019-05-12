import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ControlPanel extends JPanel implements GameControlListener{
  private static final long serialVersionUID = 1L; /* Fixed add serialVersionUID */
  private GameController gc;
  private JButton playButton;
  private JButton BoosterButton;
  private JButton AboutButton;
  private JLabel playerLabel;
  private JLabel playerColorCodeBlue;
  private JLabel playerColorCodePink;
  private JLabel playerColorCodeBlueScore;
  private JLabel playerColorCodePinkScore;


  private int p1s;
  private int p2s;

  public ControlPanel(){
    gc = GameController.getInstance();
    gc.addControlListener(this);

    JButton exitButton = new JButton("Exit");
    exitButton.setBackground(Color.RED); //Red Button by PaOv6.
    exitButton.setOpaque(true); //Red Button by PaOv6.
    exitButton.addActionListener(new ActionListener(){    
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(1);
      }
    });
    /* About Button */
    AboutButton = new JButton("About");
    AboutButton.setBackground(Color.BLUE); 
    AboutButton.setOpaque(true); 
    AboutButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        showAbout();
      }
    });

    BoosterButton = new JButton("Booster");
    BoosterButton.setBackground(Color.BLUE); //Blue Button by PaOv6.
    BoosterButton.setOpaque(true); //Green Button by PaOv6.
    BoosterButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        if(gc.getWinner() != null){
          /* Show PopUp End game if we have winner by PaOv6 */ 
          System.out.println("End game!!, Can not use Booster!!");
          JFrame endGamePopup = new JFrame();
          JOptionPane.showMessageDialog(endGamePopup, "End game!!, Can not use Booster!!");
          return;
        }
        else{
          useBooster();
        }
      }
    });

    playButton = new JButton("Play");
    playButton.setBackground(Color.GREEN); //Green Button by PaOv6.
    playButton.setOpaque(true); //Green Button by PaOv6.
    playButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        gc.takeTurn();
      }
    });

    playerLabel = new JLabel("", SwingConstants.CENTER);
    playerLabel.setFont(playerLabel.getFont().deriveFont(24.0f));
    /* Show Player 1 Name */
    playerColorCodeBlue = new JLabel("BLUE : " + gc.getPlayer1Name() ,SwingConstants.CENTER);
    playerColorCodeBlue.setFont(playerColorCodeBlue.getFont().deriveFont(16.0f));
    playerColorCodeBlue.setForeground(Color.BLUE);

    /* Show Player 1 Score */
    playerColorCodeBlueScore = new JLabel("Score : 0",SwingConstants.CENTER);
    playerColorCodeBlueScore.setFont(playerColorCodeBlueScore.getFont().deriveFont(16.0f));
    playerColorCodeBlueScore.setForeground(Color.BLUE);

    /* Show Player 2 Name */
    playerColorCodePink = new JLabel("MAGENTA : " + gc.getPlayer2Name() ,SwingConstants.CENTER);
    playerColorCodePink.setFont(playerColorCodePink.getFont().deriveFont(16.0f));
    playerColorCodePink.setForeground(Color.MAGENTA);

    /* Show Player 2 Score */
    playerColorCodePinkScore = new JLabel("Score : 0",SwingConstants.CENTER);
    playerColorCodePinkScore.setFont(playerColorCodePinkScore.getFont().deriveFont(16.0f));
    playerColorCodePinkScore.setForeground(Color.MAGENTA);

    updatePlayerLabel();
    setLayout(new GridLayout(0, 1));

    add(exitButton);
    add(AboutButton);
    add(playerLabel);
    add(playerColorCodeBlue);
    add(playerColorCodeBlueScore);
    add(playerColorCodePink);
    add(playerColorCodePinkScore);
    add(BoosterButton);
    add(playButton);    
  }

  public void changeGamePlayEnabled(boolean enabled){
    playButton.setEnabled(enabled);
    updatePlayerLabel();

    /* Update abd check Score by PaOv6. */
    updateScore();
  }

  private void updatePlayerLabel(){
    playerLabel.setText(gc.getCurrentPlayer().toString());
  }

  private void showAbout(){
    System.out.println("Show About Click!!");
    JFrame showAboutPopup = new JFrame();
    JOptionPane.showMessageDialog(showAboutPopup, "Payungsak Klinchampa" + "\n" + "5810110224");
  }

  private int getPlayerScore(){
    return gc.getCurrentPlayer().getScore();
  }
  /*Use Booster Skill */
  private void useBooster(){
    if(getPlayerScore() >= 10){
      executeBooster();   //If Player Score more then or equal to 10 , Can use it!!
    }else{
      System.out.println("You not have enoght score!!!"); //If not , Aleart Popup.
      JFrame showNotHaveEnoughtScorePopup = new JFrame();
      JOptionPane.showMessageDialog(showNotHaveEnoughtScorePopup, "You not have enoght score!!!");
    }

  }

  private void executeBooster(){
    JDialog.setDefaultLookAndFeelDecorated(true);
      /* Yes/No for use booster */
      int response = JOptionPane.showConfirmDialog(null, "Are you sure to use booster??,decress your score 10 score", gc.getCurrentPlayer().getName() + " Booster Skill",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    
      if (response == JOptionPane.NO_OPTION) {
        System.out.println("No button clicked"); //If no , Print log and nothing do anythings.
      } 
      else if (response == JOptionPane.YES_OPTION) {
        /*If yes decress score -10 , and walk 5 steps*/
        System.out.println("Yes button clicked");
        System.out.println("You use Booster!!, Your score decreee from " + getPlayerScore() + " to" + (getPlayerScore()-10));
        gc.getCurrentPlayer().decressScore();
        System.out.println("Now you [" + gc.getCurrentPlayer().getName() + "]" + " score = " + getPlayerScore());
        System.out.println("And walke 5 steps");
        gc.getCurrentPlayer().walk(5);
        System.out.println("walke 5 steps done!!");

      } 
      else if (response == JOptionPane.CLOSED_OPTION) {
        System.out.println("Closed Click!!"); //If close dialog , Print log and nothing do anythings.
      }
  }

  /* Update Score  by PaOv6. */
  private void updateScore(){
    p1s = gc.getP1Score().getScore();
    p2s = gc.getP2Score().getScore();

    String p1sAsString = String.valueOf(p1s);
    String p2sAsString = String.valueOf(p2s);

    playerColorCodeBlueScore.setText("Score : " + p1sAsString);
    playerColorCodePinkScore.setText("Score : " + p2sAsString);

  }
}