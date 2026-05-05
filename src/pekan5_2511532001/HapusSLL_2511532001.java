package pekan5_2511532001;

public class HapusSLL_2511532001 {

	// Function to delete head node
	public static NodeSLL_2511532001 deleteHead_2001(NodeSLL_2511532001 head_2001) {
		// if SLL is empty
		if (head_2001 == null)
			return null;
		
		head_2001 =	head_2001.next_2001;
		
		return head_2001;
	}
	
	// Function to delete last node
	public static NodeSLL_2511532001 removeLastNode(NodeSLL_2511532001 head_2001) {
		// If the list is empty, return null value
		if (head_2001 == null) {
			return null;
		}
		
		// If the list contains one node, delete node and return null
		if (head_2001.next_2001 == null) {
			return null;
		}
		
		// Search the second last node
		NodeSLL_2511532001 secondLast_2001 = head_2001;
		while (secondLast_2001.next_2001.next_2001 != null) {
			secondLast_2001 = secondLast_2001.next_2001;
		}
		
		// Delete last node
		secondLast_2001.next_2001 = null;
		return head_2001;
	}
	
	// Function to delete node in a certain position
	public static NodeSLL_2511532001 deleteNode_2001(NodeSLL_2511532001 head_2001, int pos_2001) {
		NodeSLL_2511532001 temp_2001 = head_2001;
		NodeSLL_2511532001 prev_2001 = null;
		
		// If linked list is null
		if (temp_2001 == null)
			return head_2001;
		
		// Kasus 1 : head dihapus
		if (pos_2001 == 1) {
			head_2001 = temp_2001.next_2001;
			return head_2001;
		}
		
		// Kasus 2 : Menghapus node di tengah
		for (int i_2001 = 1; temp_2001 != null && i_2001 < pos_2001; i_2001++) {
			prev_2001 = temp_2001;
			temp_2001 = temp_2001.next_2001;
		}
		// Jika ditemukan, hapus node
		if (temp_2001 != null) {
			prev_2001.next_2001 = temp_2001.next_2001;
		} else {
			System.out.println("Data tidak ditemukan");
		}
		return head_2001;		
	}
	
	// Function to print SLL
	public static void printList_2001(NodeSLL_2511532001 head_2001) {
		NodeSLL_2511532001 curr_2001 = head_2001;
		while (curr_2001.next_2001 != null) {
			System.out.print(curr_2001.data_2001 + "-->");
			curr_2001 = curr_2001.next_2001;
		}
		if (curr_2001.next_2001 == null) {
			System.out.print(curr_2001.data_2001);
		}
		System.out.println();
	}
	
	// Driver/Main class
	public static void main(String[] args) {
		// Create SLL 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
		NodeSLL_2511532001 head_2001 = new NodeSLL_2511532001(1);
		head_2001.next_2001 = new NodeSLL_2511532001(2);
		head_2001.next_2001.next_2001 = new NodeSLL_2511532001(3);
		head_2001.next_2001.next_2001.next_2001 = new NodeSLL_2511532001(4);
		head_2001.next_2001.next_2001.next_2001.next_2001 = new NodeSLL_2511532001(5);
		head_2001.next_2001.next_2001.next_2001.next_2001.next_2001 = new NodeSLL_2511532001(6);
		
		// Print list
		System.out.println("list awal : ");
		printList_2001(head_2001);
		
		// Delete head
		head_2001 = deleteHead_2001(head_2001);
		System.out.println("List setelah head dihapus : ");
		printList_2001(head_2001);
		
		// Delete last node
		head_2001 = removeLastNode(head_2001);
		System.out.println("List setelah simpul terakhir di hapus : ");
		printList_2001(head_2001);
		
		// Deleting node at position 2
		int pos2_2001 = 2;
		head_2001 = deleteNode_2001(head_2001, pos2_2001);
		
		// Print list after deletion
		System.out.println("List setelah posisi 2 dihapus : ");
		printList_2001(head_2001);
	}
}