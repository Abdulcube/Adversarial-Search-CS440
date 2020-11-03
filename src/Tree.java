import java.lang.*;

  public class Tree {
    // A data structure, where positions is a 2d array with 2 rows, one with
    // all the white pieces, and one with all the black pieces,
    // h is the current tree nodes heuristic values
    // x is number of home, y is Away
    Node[][] Positions;
    Node[][] b;
    int dimension;
    int x;
    int y;
    int h;
    BoardGenerator f;
    public Tree(){}

    public Tree(BoardGenerator j){
      b = j.Board;
      f=j;
      dimension = j.dimension;
      Positions = new Node[2][dimension];
      x = 0;
      y = 0;

      for (int i = 0; i <dimension; i++) {
        for (int k = 0; k < dimension ; k++) {
          if(b[i][k].side == 0){
            Positions[0][x] = b[i][k];
            x++;
          } else if(b[i][k].side == 1){
            Positions[1][y] = b[i][k];
            y++;
          }
        }
      }
      if(x == 0 && y ==0){
        Positions = null;
      }
      h = x-y;
    }

    public Tree(Tree cop ){
      b = cop.b;
      dimension = cop.dimension;

      Positions = cop.Positions.clone();
      x = cop.x;
      y = cop.y;
      h = cop.h;
    }
    //Untested minMax, Turns must work first;
    public int minMax(Tree t, int depth, int turn) throws CloneNotSupportedException {
      //Base case
      if(depth == 0 || t.Positions == null){
        return t.h;
      }
      // Homes turn
      if(turn == 0){
        Queue p = turns(t, 0);
        Tree a = p.pop();
        int val= -100;

        while(a!=null){
          a = p.pop();
          val = Math.max(val, minMax(a, depth-1, 1));
        }
        return val;
      } else {
        Queue p = turns(t, 1);
        Tree a = p.pop();
        int val= 100;

        while(a!=null){
          a = p.pop();
          val = Math.min(val, minMax(a, depth-1, 0));
        }
        return val;
      }
    }
    //Incomplete alpha beta
    public int alphabeta(Tree t, int depth, int a, int b,int turn) throws CloneNotSupportedException {
      //Base case
      if(depth == 0 || t.Positions == null){
        return t.h;
      }
      // Homes turn
      if(turn == 0){
        Queue p = turns(t, 0);
        Tree k = p.pop();
        int val= -100;
        while(k!=null){
          k = p.pop();
          val = Math.max(val, alphabeta(k, depth-1, a, b, 1));
          a = Math.max(a,val);
          if(a>=b){
            break;
          }
        }
        return val;
      } else {
        Queue p = turns(t, 1);
        Tree k = p.pop();
        int val= 100;
        while(k!=null){
          k = p.pop();
          val = Math.min(val, alphabeta(k, depth-1, a, b, 0));
          b = Math.min(b,val);
          if(a>=b){
            break;
          }
        }
        return val;
      }
    }

    // Explores a tree and returns priority Queue continaining the best moves
    public Queue turns(Tree t, int turn) throws CloneNotSupportedException {

      Queue result = new Queue();

      if(turn == 0){
        for (int i = 0; i<t.x ;i++) {
          Node current = t.Positions[0][i];
          //System.out.println("Current.type: " + current.type + current.x + current.y );
          for(int j = -1; j<=1; j++){
            for(int k = -1; k<=1; k++){
              int tempX = current.x+j;
              int tempY = current.y+k;
              if(tempX<0 || tempY<0 || tempX>=dimension || tempY>=dimension){
                  continue;
              }
              if(!b[tempX][tempY].isPit && b[tempX][tempY].side!=current.side){
                Tree p = new Tree(t);
                p.Positions[0][i].x= tempX;
                p.Positions[0][i].y= tempY;
                  if(b[tempX][tempY].side==1){
                    p.h++;
                  }
                result.add(p);
                p.h--;
              }
            }
          }

        }
      } else {
        for (int i = 0; i<t.x ;i++) {
          Node current = t.Positions[0][i];
          //System.out.println("Current.type: " + current.type + current.x + current.y  );
          for(int j = -1; j<=1; j++){
            for(int k = -1; k<=1; k++){
              int tempX = current.x+j;
              int tempY = current.y+j;
              if(tempX<0 || tempY<0 || tempX>=dimension || tempY>=dimension){
                  continue;
              }
              if(!b[tempX][tempY].isPit && b[tempX][tempY].side!=current.side){
                Tree p = new Tree(t);
                p.Positions[0][i].x= tempX;
                p.Positions[0][i].y= tempY;
                if(b[tempX][tempY].side==0){
                    p.h++;
                    result.add(p);
                    p.h--;
                  } else {
                    result.add(p);
                  }

              }
            }
          }
        }
      }
      return result;
    }



    public void traverse() {
		    for(int i = 0; i < 2; i ++) {
			       for( int k = 0; k < dimension; k ++) {
				           System.out.print(""+ Positions[i][k].type+ " : " +Positions[i][k].side +" ");
			       }
			       System.out.println();
		    }
		    return;
	  }


}
