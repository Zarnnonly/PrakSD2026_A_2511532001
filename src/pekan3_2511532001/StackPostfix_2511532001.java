package pekan3_2511532001;
import java.util.Scanner;
import java.util.Stack;

public class StackPostfix_2511532001 {
	public static int postfixEvaluate_2511532001(String expression) {
		Stack<Integer> s_2001 = new Stack<Integer>();
		Scanner input = new Scanner (expression);
		while (input.hasNext()) {
			if (input.hasNextInt()) {
				s_2001.push(input.nextInt());
			} else {
				String operator = input.next();
				int operand2 = s_2001.pop();
				int operand1 = s_2001.pop();
				if (operator.equals("+")) {
					s_2001.push(operand1 + operand2);
				} else if (operator.equals("-")) {
					s_2001.push(operand1 - operand2);
				} else if (operator.equals("*")) {
					s_2001.push(operand1 * operand2);
				} else {
					s_2001.push(operand1 / operand2);
				}
			}
		}
		input.close();
		return s_2001.pop();
	}
	public static void main (String[]args) {
		System.out.println("hasil postfix: "+ postfixEvaluate_2511532001("5 2 4 * + 7 - "));
	}
}
