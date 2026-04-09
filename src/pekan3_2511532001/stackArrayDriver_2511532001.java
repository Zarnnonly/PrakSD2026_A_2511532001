package pekan3_2511532001;

public class stackArrayDriver_2511532001 {
	public static void main (String[]args) {
		stackArray_2511532001 s = new stackArray_2511532001();
		s.push_2001(10);
		s.push_2001(20);
		s.push_2001(30);
		System.out.println(s.pop_2001() + " dikeluarkan dari stack");
		System.out.println("Elemen teratas adalah: " + s.peek_2001());
		System.out.println("Element pada stack: ");
		s.print_2001();
	}

}
