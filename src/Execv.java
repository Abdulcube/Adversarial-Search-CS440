import java.util.Scanner;

public class Execv {
	public static void main(String[] args) {



		//Can be 3,6, or 9
		BoardGenerator b = new BoardGenerator(3);
			DrawBoard d = new DrawBoard(b);
	//	DrawBoard d = new DrawBoard(b);
	// Works!!! to an extent lol

		int k =0;
		while( k!=1){
			k = IO.readInt();
		 	Algorithm j = new Algorithm(b.Board, 1 , 1);
			b.Board = j.finalState.grid;
			if(j.finalState.x == 0 || j.finalState.y == 0){
				return ;
			}
		//.	sleep(2);

			d.updateBoard();
		}

/*
		// Works!!!
		int k=0;
		while(k!=1){
			k = IO.readInt();
			State s = new State(b.Board);
			//b.traverse();
			s.traverse();
			Queue q = Algorithm.turns(s,1);
			q.traverse();
			s.traverse();
			System.out.println();
			State r = q.pop();
			System.out.println();
			r.traverse();
			System.out.println("Heuristic: " + r.h);

			b.Board = r.grid;
			d.updateBoard();

		}*/


		//int turn = d.board.turn;

	//	System.out.println("turn: " + 	d.board.turn);

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
	/*	while(true) {
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
*/
	}
}
