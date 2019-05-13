import javax.swing.*;
import java.awt.*;

public class GameMain{
	public static void main(String[] args){
		JFrame frame = new JFrame("Game");
		GamePanel gp = new GamePanel();
		ControlPanel cp = new ControlPanel();
		frame.add(gp, BorderLayout.CENTER);
		frame.add(cp, BorderLayout.PAGE_END);
		frame.setUndecorated(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 400);
    frame.setVisible(true);
	}
}
