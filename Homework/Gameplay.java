public class Gameplay{
	public static void main(String args[]){
		int winner_score = 30;

		Game p1 = new Game(winner_score);
		Game p2 = new Game(winner_score);

		p1.walk("Player1",10);
		p2.walk("Player2",5);
		p1.walk("Player1",20);
		p2.walk("Player2",5); //player 1 winner!!
	}
}