public class Dice {
  private int face;

  public void roll() {
    face = (int) (Math.random() * 6) + 1;
  }

  public int getFace() {
    return face;
  }
}