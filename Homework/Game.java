public class Game{
	private int winner_score;
	private int all_num = 0;
	
	private int p1;
	private int p2;

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
	
	public void isEnd(){
		if (p1 >= max_slot || p2 >= max_slot)
			System.out.println("PLAYER 1 WINER!!");
		else if(p2 >= max_slot)
			System.out.println("PLAYER 2 WINNER!!");
	}
}
