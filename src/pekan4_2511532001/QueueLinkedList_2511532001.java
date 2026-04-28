package pekan4_2511532001;
import java.util.*;

public class QueueLinkedList_2511532001 {
	public static void main (String[]args) {
		Queue<Integer> q_2001 = new LinkedList<>();
		// tambah elemen
		for (int i = 0; i < 6; i++)
			q_2001.add(i);
		// Menampilkan isi
		System.out.println("Elemen Antrian" + q_2001);
		// Untuk menghapus kepala antrian
		int hapus_2001 = q_2001.remove();
		System.out.println("Hapus Elemen" + hapus_2001);
		System.out.println(q_2001);
		// Untuk melihat antrian terdepan
		int depan_2001 = q_2001.peek();
		System.out.println("Kepala Antrian " + depan_2001);
		
		int banyak_2001 = q_2001.size();
		System.out.println("Size Antrian " + banyak_2001);

		
	}
}
