
public class Execv {
	public static void main(String[] args) throws CloneNotSupportedException {


		//Can be 3,6, or 9
		BoardGenerator b = new BoardGenerator(6);
	 	Tree t = new Tree(b);
		//DrawBoard d = new DrawBoard(b);
	//	t.traverse();


		Queue q = t.turns(t,1);
		t.traverse();
		q.traverse();
		System.out.println();
		b.traverse();
		/*	b.traverse();
		System.out.println(" Pow ");
		t.traverse();
		//DrawBoard d = new DrawBoard(b);
		Queue p = new Queue();
		p.add(t);
		p.add(t);
		p.traverse();*/

		//System.out.println("" + p.pop().dimension);


	}
}
