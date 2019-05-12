import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
  private BoardPanel boardPanel;
  private ControlPanel controlPanel;

  public GameFrame(){
    super("Game | Payungsak Klinchampa | 5810110224");
    boardPanel = new BoardPanel(820, 512); //512
    controlPanel = new ControlPanel();
    setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit on close by PaOv6.
    setUndecorated(false);  //Set to false by PaOv6.
    setSize(1000, 534); //512
    setResizable(true);
    add(boardPanel, BorderLayout.CENTER);
    controlPanel.setPreferredSize(new Dimension(180, 0));
    add(controlPanel, BorderLayout.LINE_END);

    setVisible(true);
  }
}