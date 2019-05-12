//import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameController implements PlayerListener {
  private Board board;
  private Dice d1 = new Dice();
  private Dice d2 = new Dice();

  private Player p1;
  private Player p2;
  private Player currentPlayer;
  private Player winner = null;

  private String p1_name = "P1";
  private String p2_name = "P2";
  

  private List<Sprite> players = new ArrayList<>();

  private List<GameSpriteListener> spriteListeners = new ArrayList<>();
  private List<GameControlListener> controlListeners = new ArrayList<>();

  private static GameController instance;
  public static GameController getInstance(){
    if(instance == null){
      instance = new GameController();
    }
    return instance;
  }
  private GameController() {
    board = new Board(80);
     /* Set Player name by PaOv6 */ 
    p1_name = (String)JOptionPane.showInputDialog(
        null,
        "\"Input Player1 name?\"",
        "Input Player1 name",
        JOptionPane.PLAIN_MESSAGE,
        null,
        null,
        "P1");

      p2_name = (String)JOptionPane.showInputDialog(
        null,
        "\"Input Player2 name?\"",
        "Input Player2 name",
        JOptionPane.PLAIN_MESSAGE,
        null,
        null,
        "P2");

    p1 = new Player(p1_name, 0, board, this);
    p2 = new Player(p2_name, 1, board, this);
    currentPlayer = p1;
    
    players.add(p1);
    players.add(p2);    
  }

  private void rollDice() {
    d1.roll();
    d2.roll();
  }

  public void takeTurn() {
    if(winner != null){
       /* Show PopUp Engame if we have winner by PaOv6 */ 
      System.out.println("End game!!");
      JFrame endGamePopup = new JFrame();
      JOptionPane.showMessageDialog(endGamePopup, "End game!!");
      return;
    }
      

    rollDice();  //Roll Dice
    
    /* Magic Face Number by PaOv6. */
    int allFace = d1.getFace() + d2.getFace();

    if(allFace == 12){
      currentPlayer.walk(0);
      System.out.println(currentPlayer.getName() + " getFace = 12" + " ,You must stop walk!!");
    }
    else if((d1.getFace() == 1 && d2.getFace() == 6) || (d1.getFace() == 6 && d2.getFace() == 1)){
      System.out.println("You get d1 = 1 and d2 = 6," + currentPlayer.getName() + " must stop walk!!");
      changeTurn();
      System.out.println(currentPlayer.getName() + " Walk!!");
      currentPlayer.walk(allFace);
    }
    else if (d1.getFace() == d2.getFace()){
      //Do Somethings.
    }
    else{
      //currentPlayer.walk(d1.getFace() + d2.getFace());
      currentPlayer.walk(allFace);
    }
  }

  private void changeTurn() {
    if (currentPlayer == p1)
      currentPlayer = p2;
    else
      currentPlayer = p1;
  }

  @Override
  public void walking(Player owner){
    notifyGamePlayEnabled(false);
    for(GameSpriteListener listener : spriteListeners){
      listener.spriteUpdated();
    }
  }

  @Override
  public void walkCompleted(Player onwer) {        
    changeTurn();
    notifyGamePlayEnabled(true);
  }

  @Override
  public void hasWon(Player owner) {
    if (winner == null) { // first winner only
      winner = owner;
    }
  }

  public Player getWinner() {
    return winner;
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  /* getPlayer 1 Name by PaOv6 */ 
  public String getPlayer1Name(){
    return p1_name;
  }

  /* getPlayer 2 Name by PaOv6 */ 
  public String getPlayer2Name(){
    return p2_name;
  }

  /* get P1 Score by PaOv6 */ 
  public Player getP1Score(){
    return p1;
  }

   /* get P2 Score by PaOv6 */ 
  public Player getP2Score(){
    return p2;
  }

  public List<Sprite> getSprites(){
    return players;
  }

  public void addSpriteListener(GameSpriteListener listener){
    spriteListeners.add(listener);
  }

  public void addControlListener(GameControlListener listener){
    controlListeners.add(listener);
  }

  public void notifyGamePlayEnabled(boolean enabled){
    for(GameControlListener listener : controlListeners){
      listener.changeGamePlayEnabled(enabled);
    }
  }

}