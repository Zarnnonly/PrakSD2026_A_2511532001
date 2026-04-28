package pekan4_2511532001;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class IterasiQueue_2511532001 {
	public static void main (String[]args) {
		Queue<String> q_2001 = new LinkedList<>();
		
		q_2001.add("Praktikum");
		q_2001.add("Struktur");
		q_2001.add("Data");
		q_2001.add("Dan");
		q_2001.add("Algoritma");
		Iterator <String> iterator_2001 = q_2001.iterator();
		while (iterator_2001.hasNext()) {
			System.out.print(iterator_2001.next() + " ");
		}
	}

}
