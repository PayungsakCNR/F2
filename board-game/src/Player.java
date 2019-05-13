import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Player extends Sprite {
  private static Color[] COLORS = {Color.BLUE, Color.MAGENTA };
  private String name;
  private int index;
  private Board board;
  private PlayerListener listener;
  private int currentPos = 1;
  private int score = 0; //define default score (0)

  public Player(String name, int index, Board board, PlayerListener listener) {
    this.name = name;
    this.index = index;
    this.board = board;
    this.listener = listener;
  }

  public void walk(int steps) {
     /* Step Bonus by PaOv6 */ 
    if(steps == 5){
      steps += 1;
      System.out.println(this + " getAllFace = 5" + " ,Bonus Walk +1" + " ,All step = " + steps);
    }
    else if(steps == 10){
      steps += 2;
      System.out.println(this + " getAllFace = 10" + " ,Bonus Walk +2"  + " ,All step = " + steps);
    }
    else if(steps == 7){
      steps -= 2;
      System.out.println(this + " getAllFace = 7" + " ,Bonus Walk -2"  + " ,All step = " + steps);
    }
    else if(steps == 9){
      steps -= 3;
      System.out.println(this + " getAllFace = 9" + " ,Bonus Walk -2"  + " ,All step = " + steps);
    }
    int next_position = Math.min(currentPos + steps, board.getFinishPos());
    System.out.println(this + " walks from " + currentPos + " to " + next_position);
    new WalkerThread(next_position).start();  
  }

  public void doWalking(){
    listener.walking(this);
  }

  public void doWalkCompleted(){
    Integer tunnelOutPos = board.getTunnelOutPos(currentPos);
     /* MEGIC Area by PaOv6 */ 
    if(currentPos == 17){
      setScore(10);
      System.out.println("Now you stop at MAGIC Area | You got 10 score!!");
    }
    if(currentPos == 32){
      setScore(20);
      System.out.println("Now you stop at MAGIC Area | You got 20 score!!");
    }
    if(currentPos == 47){
      setScore(10);
      System.out.println("Now you stop at MAGIC Area | You got 10 score!!");
    }
    if(currentPos == 68){
      setScore(5);
      System.out.println("Now you stop at MAGIC Area | You got 5 score!!");
    }
    if(tunnelOutPos != null){
      System.out.println(this + " enter tunnel from " + currentPos + " to " + tunnelOutPos.intValue());
      currentPos = tunnelOutPos.intValue();
      listener.walking(this);
    }
    listener.walkCompleted(this);
    if (currentPos >= board.getFinishPos()) {      
      this.listener.hasWon(this);
      /* Show PopUp Winner name by PaOv6 */ 
      System.out.println(this + " is winner!!, Your Score = " + score);
      JFrame winnerPopup = new JFrame();
      JOptionPane.showMessageDialog(winnerPopup, this + " is winner!!, Your score = " + score);
    }   
  }

  @Override
  public void draw(Graphics2D g2d){
    if(currentPos > 0){
      g2d.setColor(COLORS[index]);
      Point ref = board.getRefLocationForPos(currentPos);
      g2d.fillOval(ref.x + 10 + (index * 40), ref.y + 30, 20, 20);
    }
  }

  public String getName() {
    return name;
  }
  
  /* get  Score by PaOv6 */ 
  public int getScore() {
    return score;
  }

  /* set Score by PaOv6 */ 
  public int setScore(int sc){
    return score += sc;
  }

  /* decress 10 Score by PaOv6 */ 
  public void decressScore(){
    score -= 10;
  }

  @Override
  public String toString() {
    return getName();
  }  

  private class WalkerThread extends Thread {
    private int toPos;
    public WalkerThread(int toPos){
      this.toPos = toPos;
    } 
    public void run(){
      while(currentPos < toPos){
        currentPos ++;
        doWalking();
        try{ Thread.sleep(300); } catch(Exception e){}        
      }
      doWalkCompleted();
    }
  }
}
