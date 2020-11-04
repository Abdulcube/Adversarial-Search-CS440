import java.io.*;
import java.util.*;

public class Queue {
	List<State> head;
	int size;

	public Queue() {
		head = null;
		size = 0;
	}

	public void add(State t) {
		if (head == null) {
			head = new ArrayList<State>();
			head.add(t);
			size = 1;
			return;
		}
		for (int counter = 0; counter < head.size(); counter++) {
			if (head.get(counter).h <= t.h) {
				head.add(counter, t);
				size = head.size();
				return;
			}
		}
		head.add(t);

	}

	public void traverse() {
		for (int counter = 0; counter < size; counter++) {
			if (head.get(counter) != null) {
				System.out.print("" + head.get(counter).h + "");
			}
		}
	}

	public State pop() {
		if (head == null) {
			return null;
		}
		State res = head.get(0);
		head.remove(0);
		size--;
		if (size == 0) {
			head = null;
		}
		return res;
	}
	
	public State popsB() {
		if (head == null) {
			return null;
		}
		State res = head.get(size-1);
		head.remove(size -1);
		size--;
		if (size == 0) {
			head = null;
		}
		return res;
	}
	public boolean isEmpty() {
		if( size == 0) {
			return true;
		}
		return false;
	}
}
