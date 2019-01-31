public class Dice {
  private int diceVal;
  
  public Dice(){
     diceVal = 1;
  }
  public int DiceRandom(){
     diceVal = (int)(Math.random()*6+1);
  }
}
