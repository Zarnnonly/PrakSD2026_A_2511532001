package pekan5_2511532001;

public class TambahSLL_2511532001 {
	public static NodeSLL_2511532001 insertAtFront_2001(NodeSLL_2511532001 head_2001, int value_2001) {
		NodeSLL_2511532001 new_node_2001 = new NodeSLL_2511532001(value_2001);
		new_node_2001.next_2001 = head_2001;
		return new_node_2001;
	}
	
	// Adds node in the end funct
	public static NodeSLL_2511532001 insertAtEnd_2001(NodeSLL_2511532001 head_2001, int value_2001) {
		// create node with a value
		NodeSLL_2511532001 newNode_2001 = new NodeSLL_2511532001(value_2001);
		
		// If list isEmpty, then node becomes head
		if (head_2001 == null) {
			return newNode_2001;
		}
		
		// Store head to temp. var.
		NodeSLL_2511532001 last_2001 = head_2001;
		// Find to last node
		while (last_2001.next_2001 != null) {
			last_2001 = last_2001.next_2001;
		}
		
		// Change pointer
		last_2001.next_2001 =  newNode_2001;
		return head_2001;
	}
	static NodeSLL_2511532001 getNode_2001(int data_2001) {
		return new NodeSLL_2511532001(data_2001);
	}
	
	static NodeSLL_2511532001 insertPos_2001(NodeSLL_2511532001 headNode_2001, int pos_2001, int val_2001) {
		NodeSLL_2511532001 head_2001 = headNode_2001;
		if (pos_2001 < 1) {
			System.out.println("Invalid position.");
		}
		if (pos_2001 == 1) {
			NodeSLL_2511532001 new_node_2001 = new NodeSLL_2511532001(val_2001);
			new_node_2001.next_2001 = head_2001;
			return new_node_2001;
		} else {
			while (pos_2001-- != 0) {
				if (pos_2001 == 1) {
					NodeSLL_2511532001 newNode_2001 = getNode_2001(val_2001);
					newNode_2001.next_2001 = headNode_2001.next_2001;
					headNode_2001.next_2001 = newNode_2001;
					break;
				}
				headNode_2001 = headNode_2001.next_2001;
			}
			if (pos_2001 != 1)
				System.out.println("Posisi di luar jangkauan");
		}
		return head_2001;
	}
	public static void printList_2001(NodeSLL_2511532001 head_2001) {
		NodeSLL_2511532001 curr_2001 = head_2001;
		while (curr_2001.next_2001 != null) {
			System.out.print(curr_2001.data_2001 + "-->");
			curr_2001 = curr_2001.next_2001;
		}
		if (curr_2001.next_2001 == null) {
			System.out.print(curr_2001.data_2001);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		NodeSLL_2511532001 head_2001 = new NodeSLL_2511532001(2);
		head_2001.next_2001 = new NodeSLL_2511532001(3);
		head_2001.next_2001.next_2001 = new NodeSLL_2511532001(5);
		head_2001.next_2001.next_2001.next_2001 = new NodeSLL_2511532001(6);
		
		System.out.print("Senarai berantai awal : ");
		printList_2001(head_2001);
		
		System.out.print("tambah 1 simpul di depan: ");
		int data_2001 = 1;
		head_2001 = insertAtFront_2001(head_2001, data_2001);
		
		printList_2001(head_2001);
		
		System.out.print("tambah 1 simpul di belakang: ");
		int data2_2001 = 7;
		head_2001 = insertAtEnd_2001(head_2001, data2_2001);
		
		printList_2001(head_2001);
		
		System.out.print("tambah 1 simpul ke data 4: ");
		int data3_2001 = 4 ; 
		int pos_2001 = 4 ; 
		head_2001 = insertPos_2001(head_2001, pos_2001, data3_2001);
		
		printList_2001(head_2001);
	}
}