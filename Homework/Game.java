public class Game{
	private int winner_score;
	private int all_num = 0;

	public Game(int win){
		winner_score = win;
	}
	public void walk(String s,int num){
		all_num += num;
		if(all_num >= winner_score){
			printWinner(s);
		}
	}

	public void printWinner(String s){
		System.out.println( s + " Winner!!");
	}
}