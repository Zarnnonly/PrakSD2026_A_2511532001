package pekan4_2511532001;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseData_2511532001 {
	public static void main (String[]args) {
		Queue<Integer> q_2001 = new LinkedList<Integer>();
		q_2001.add(1);
		q_2001.add(2);
		q_2001.add(3);
		System.out.println("Sebelum reverse " + q_2001);
		Stack<Integer> s_2001 = new Stack<Integer>();
		while (!q_2001.isEmpty()) {
			s_2001.push(q_2001.remove());
		}
		while (!s_2001.isEmpty()) {
			q_2001.add(s_2001.pop());
	}
		System.out.println("Sesudah reverse " + q_2001);
	}
}
