import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	public GamePanel(){
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0,0,800,360);
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(0,250,800,360);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(90,150,50,150);
        
        g2d.setColor(Color.GREEN);
        g2d.fillOval(115,120,100,100);
        g2d.setColor(Color.GREEN);
        g2d.fillOval(30,120,100,100);
        g2d.setColor(Color.GREEN);
        g2d.fillOval(70,80,100,100);
      
        g2d.setColor(Color.RED);
        g2d.fillOval(100,90,10,10);
        g2d.setColor(Color.RED);
        g2d.fillOval(115,120,10,10);
        g2d.setColor(Color.RED);
        g2d.fillOval(150,130,10,10);
        g2d.setColor(Color.RED);
        g2d.fillOval(100,150,10,10);

        g2d.fillPolygon(new int[] {400,500, 450}, new int[] {200,200,100}, 3); //Fills triangle
        g2d.setColor(Color.WHITE);
        g2d.fillOval(425,60,50,50);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(440,200,10,50);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(460,200,10,50);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(440,120,50,10);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(460,120,50,10);

        g2d.setColor(Color.BLACK);
        g2d.fillOval(460,70,10,10);

        g2d.setColor(Color.YELLOW);
        g2d.fillOval(430,50,30,30);
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(410,60,30,30);
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(420,80,30,30);
	}
}
