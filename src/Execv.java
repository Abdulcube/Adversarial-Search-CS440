import java.util.Scanner;

public class Execv {
	public static void main(String[] args) {
			
		
		
		//Can be 3,6, or 9
		BoardGenerator b = new BoardGenerator(3);
		
		DrawBoard d = new DrawBoard(b);
		
		State s = new State(b.Board);
		
		Queue q = Algorithm.turns(s,0);
		q.traverse();
		
		
		//int turn = d.board.turn;
		
		System.out.println("turn: " + 	d.board.turn);
		
		/*
		while(true) { //game not over
			
			
			if(d.board.getTurn() == 0) { //users turn
				continue;
			}
			if(d.board.getTurn() == 1) {
				System.out.println(":");
				Algorithm a = new Algorithm(b.Board);
				b.Board = a.finalState.grid;
				
				//System.out.println(":");
				
				d.updateBoard();
				
				d.board.turn = 0;
			}
		}
		*/
		while(true) {
			 Scanner scan = new Scanner(System.in);
			 int num = scan.nextInt();
			 
			  if (num == 1) {
					System.out.println(":");
					Algorithm a = new Algorithm(d.board.Board); //b.Board
					d.board.Board = a.finalState.grid;
					
					//System.out.println(":");
					
					d.updateBoard();
			  }
		}
		
	}
}
