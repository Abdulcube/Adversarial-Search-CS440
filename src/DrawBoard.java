import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawBoard {
	
	int dimension;
	int Csize;
	JFrame frame;
	Board canvas;
	BoardGenerator board;
	
	//Default Constructor - 3 x 3
	public DrawBoard() {
		this.dimension = 3;
		this.board = new BoardGenerator();
		Csize = XSIZE / dimension;
		
		init();
	}
	
	//Constructor for size of board.
	public DrawBoard(BoardGenerator b) {
		this.dimension = b.dimension;
		this.board = b;
		Csize = XSIZE / dimension;
		
		init();
	}
	
	private final int X = 640;
	private final int XSIZE = 600;
	//	private int Csize =  XSIZE / dimension;
	
	public void init() {	
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(X,X);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		initBoard();
		
		frame.getContentPane().add(canvas);
		
	}
	
	public void initBoard() {
		
		canvas = new Board();
		canvas.setBounds(10, 10, XSIZE+1, XSIZE+1);

	}
	
	public void updateBoard() {
		
		
		try {
			Thread.sleep(15);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
		
		canvas.repaint();
	}
	
	class Board extends JPanel {	
		public void paintComponent(Graphics g) {
			for(int x = 0; x < dimension; x++) {
				for(int k = 0; k < dimension; k++ ) {

					System.out.println("x,y " + x + "," + k + "  typ:  " + board.Board[x][k].type);
					
					g.setColor(new Color(170,170,170)); //Light Gray
					g.fillRect(x*Csize,k*Csize,Csize,Csize);
					g.setColor(Color.BLACK);
					g.drawRect(x*Csize,k*Csize,Csize,Csize);
					
					//For Peices to be Drawn
					if(board.Board[x][k].side == 0) {
						//Cream
						g.setColor(new Color(255,255,200));
					} else {
						//Dark
						g.setColor(new Color(153,0,0));
					}
					
					if (board.Board[x][k].type == 'm') {
						
						g.setFont(new Font("Arial",Font.BOLD,40));
						//Draw String in JPanel
						g.drawString("M",x*Csize+15,k*Csize+50);
						
					} else if (board.Board[x][k].type == 'h') {
						
						g.setFont(new Font("Arial",Font.BOLD,40));
						//Draw String in JPanel
						g.drawString("H",x*Csize+15,k*Csize+50);
						
					} else if (board.Board[x][k].type == 'w') {
						
						g.setFont(new Font("Arial",Font.BOLD,40));
						//Draw String in JPanel
						g.drawString("W",x*Csize+15,k*Csize+50);
					} //For Peices to be Drawn
					
					
					
					if(board.Board[x][k].isPit == true) {
						g.setColor(new Color(75,75,75)); //Dark Grey
						g.fillOval(x*Csize,k*Csize,Csize,Csize);
					}
					
					
				}
			}
		}
	}	
}
