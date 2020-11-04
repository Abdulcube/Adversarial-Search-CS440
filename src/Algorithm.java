
public class Algorithm {

	State finalState;
	Node[][] grid;
	BoardGenerator b;
	DrawBoard d;

	public Algorithm (Node[][] g, int i, int depth){
		System.out.println("____________________");
		//changes state to new board after the best possible move has been made
		State t = new State(g);
		int v = 0;

		v = minMax(t, depth , i, depth);

	}

	// Untested minMax, Turns must work first;
	public int minMax(State t, int depth, int turn, int start) {
		// Base case
		if(t.x == 0 && turn == 0){
			return -20;
		} else if(t.y == 0 && turn == 1){
			return 20;
		}
		if (depth == 0 || t.grid == null ) {
		//	finalState = t;
			return t.h;
		}
		// Homes turn
		if (turn == 0) {
			Queue p = turns(t, 0);
			int val = -100;

			while (!p.isEmpty()) {
				State a = p.pop();
				int runner = Math.max(val, minMax(a, depth - 1, 1,start));
				if (val < runner) {
					//finalState = a;
					val = runner;
					if(start == depth){
						//System.out.print()
						finalState = a;
					}
				}

			}
			return val;
		} else {
			Queue p = turns(t, 1);
			int val = 100;

			while (!p.isEmpty()) {
				State a = p.popsB();
				int runner = Math.min(val, minMax(a, depth - 1, 0,start));
				if (val > runner) {

					//finalState = a;
					val = runner;
					if(start == depth){
						//System.out.print()
						finalState = a;
					}
				}

			}

			return val;
		}
	}

	// Explores a state and returns priority Queue continaining the best moves
	public static Queue turns(State t, int turn) {
		Queue result = new Queue();

		if (turn == 0) {
			for (int i = 0; i < t.dimension; i++) {
				for (int k = 0; k < t.dimension; k++) {
					if(t.grid[i][k].side == 0) {

						//Double Loop for local moves
						for (int j = -1; j <= 1; j++) {
							for (int p = -1; p <= 1; p++) {

								int tempX = i + j;
								int tempY = k + p;
								if(tempX < 0 || tempY < 0 || (j == 0 && p == 0)){
									continue;
								} else if (tempX >= t.dimension || tempY >= t.dimension || t.grid[tempX][tempY].side == 0 || t.grid[tempX][tempY].isPit) {
									continue;

								} else {
									if (t.grid[tempX][tempY].side == 1 ) { //is their peice

										State s = new State(t.grid);
										s.grid[tempX][tempY] = t.grid[i][k];
										s.grid[i][k].reset();
										s.h ++;
										result.add(s);
									} else {
										State s = new State(t.grid);
										s.grid[tempX][tempY] = t.grid[i][k];
										s.grid[i][k].reset();
										result.add(s);
									}
								}
							}
						}
					}
				}
			}
		} else {
			for (int i = 0; i < t.dimension; i++) {
				for (int k = 0; k < t.dimension; k++) {
					if(t.grid[i][k].side == 1) {

						//Double Loop for local moves
						for (int j = -1; j <= 1; j++) {
							for (int p = -1; p <= 1; p++) {

								int tempX = i + j;
								int tempY = k + p;
								if(tempX < 0 || tempY < 0 || (j == 0 && p == 0)){
									continue;
								} else if (tempX >= t.dimension || tempY >= t.dimension || t.grid[tempX][tempY].side == 1 || t.grid[tempX][tempY].isPit) {
									continue;

								} else {
									if (t.grid[tempX][tempY].side == 0) { //is their peice

										State s = new State(t.grid);
										s.grid[tempX][tempY] = t.grid[i][k];
										s.grid[i][k].reset();
										s.h--;
										result.add(s);
									} else {
										State s = new State(t.grid);
										s.grid[tempX][tempY] = t.grid[i][k];
										s.grid[i][k].reset();
										result.add(s);
									}
								}
							}
						}
					}
			}
		}
		}
		if(result.isSame()){
			result.jumble();
		}
		return result;
	}


}
