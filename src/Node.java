
//Nodes make up the entirety of the the board spaces
public class Node { 
	
	int side; //0 for home (white) 1 for away (dark)
	char type = 'n';  //'h' for hero 'w' for wumpus 'm' for mage 'n' for null
	
	boolean isPit = false;
	
	int x;
	int y;
	

	//Default Constructor for BoardGenerator
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
