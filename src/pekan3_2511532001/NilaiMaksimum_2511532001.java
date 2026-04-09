package pekan3_2511532001;
import java.util.Stack;

public class NilaiMaksimum_2511532001 {
	public static int max_2511532001(Stack<Integer> s_2001) {
		Stack<Integer> backup = new Stack<Integer>();
		int maxValue = s_2001.pop();
		backup.push (maxValue);
		while (!s_2001.isEmpty()) {
			int next = s_2001.pop();
			backup.push(next);
			maxValue = Math.max(maxValue, next);
		}
		while (!backup.isEmpty()) {
			s_2001.push(backup.pop());
		}
		return maxValue;
	}
	public static void main (String[]args) {
		Stack<Integer> s_2001 = new Stack<Integer>();
		s_2001.push(70);
		s_2001.push(12);
		s_2001.push(20);
		System.out.println("isi stack "+ s_2001);
		System.out.println("Stack Teratas "+ s_2001.peek());
		System.out.println("Nilai maksimum "+ max_2511532001(s_2001));
	}
}
