package pekan3_2511532001;

public class stackArray_2511532001 {
	static final int MAX = 1000;
	int top;
	int a[] = new int [MAX];
	boolean isEmpty_2001()
	{
		return (top < 0);
	}
	stackArray_2511532001()
	{
		top = -1;
	}
	boolean push_2001 (int x)
	{
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			a[++top] = x;
			System.out.println(x + " dimasukkan dalam stack");
			return true;
		}
	}
	int pop_2001()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top--];
			return x;
		}
	}
	int peek_2001()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a[top];
			return x;
		}
	}
	void print_2001() {
		for(int i = top;i>-1;i--) {
			System.out.print(" " + a[i]);
		}
	}
}
