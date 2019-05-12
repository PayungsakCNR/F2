public class Main {
  public static void main(String[] args) {
    GameController gc = GameController.getInstance();
    /*
    while (gc.getWinner() == null) {
      gc.takeTurn();
    }
    System.out.println(gc.getWinner() + " is a winner");
    */
    new GameFrame();
  }
}