package Test;
import java.util.ArrayList;
import java.util.LinkedList;


public class Test7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 7;
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i ++)
			l.add(i);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		while (!l.isEmpty()) {
			a.add(l.removeFirst());
			
			if (l.size() >= 2)
				l.add(l.removeFirst());
		}
		
		for (int i : a)
			System.out.print(i + " ");
	}

}
