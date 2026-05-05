package pekan5_2511532001;

public class PencarianSLL_2511532001 {
	
	static boolean searchKey_2001(NodeSLL_2511532001 head_2001, int key_2001) {
		NodeSLL_2511532001 curr_2001 = head_2001;
		while (curr_2001 != null) {
			if (curr_2001.data_2001 == key_2001)
				return true;
			curr_2001 = curr_2001.next_2001;					
		}
		return false;
	}
	
	public static void traversal_2001(NodeSLL_2511532001 head_2001) {
		// Start from head
		NodeSLL_2511532001 curr_2001 = head_2001;
		
		// Search until pointer == null
		while (curr_2001 != null) {
			System.out.print(" " + curr_2001.data_2001);
			curr_2001 = curr_2001.next_2001;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		NodeSLL_2511532001 head_2001 = new NodeSLL_2511532001(14);
		head_2001.next_2001 = new NodeSLL_2511532001(21);
		head_2001.next_2001.next_2001 = new NodeSLL_2511532001(13);
		head_2001.next_2001.next_2001.next_2001 = new NodeSLL_2511532001(30);
		head_2001.next_2001.next_2001.next_2001.next_2001 = new NodeSLL_2511532001(10);
		System.out.print("Penelusuran SLL : ");
		traversal_2001(head_2001);
		
		// Data that will be searched
		int key_2001 = 30;
		System.out.print("Cari data " + key_2001 + " = ");
		if (searchKey_2001(head_2001, key_2001))
			System.out.println("Data ditemukan");
		else 
			System.out.println("Data tidak ditemukan");
	}
}