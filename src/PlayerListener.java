public interface PlayerListener {
  void walking(Player owner);
  void walkCompleted(Player onwer);
  void hasWon(Player owner);
}