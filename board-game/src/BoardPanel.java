import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel implements GameSpriteListener{
  private GameController gc;
  private Graphics2D g2d;
  private BufferedImage bufferedImage;
  private Image backgrounImage;

  public BoardPanel(int w, int h){
    gc = GameController.getInstance();
    gc.addSpriteListener(this);
    
    bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    g2d = (Graphics2D) bufferedImage.getGraphics();
    try{
      backgrounImage = ImageIO.read(new File("src/pao-board.png"));    
      g2d.setBackground(Color.BLACK);
      g2d.drawImage(backgrounImage, 0, 0, null);
    }catch(Exception e){
      System.out.println("Background image not found.");
    }
  }

  public void spriteUpdated(){    
    redraw();
  }

  public void changeGamePlayEnabled(boolean enabled){
    //do nothing
  }

  public void redraw(){
    g2d.clearRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    g2d.drawImage(backgrounImage, 0, 0, null);
    for(Sprite sprite: gc.getSprites()){
      sprite.draw(g2d);
    }
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(bufferedImage, 0, 0, null);
  }
}