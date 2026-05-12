package pekan6_2511532001;

public class InsertDLL_2511532001 {
    //menambahkan node di awal DLL
    static NodeDLL_2511532001 insertBegin_2001(NodeDLL_2511532001 head_2001, int data_2001) {
        // buat node baru
    	NodeDLL_2511532001 new_node_2001 = new NodeDLL_2511532001(data_2001);
        // jadikan pointer nextnya head
        new_node_2001.next_2001 = head_2001;
        // jadikan pointer prev head ke new_node
        if (head_2001 != null) {
            head_2001.prev_2001 = new_node_2001;
        }
        return new_node_2001;
    }
    // fungsi menambahkan node di akhir
    public static NodeDLL_2511532001 insertEnd_2001(NodeDLL_2511532001 head_2001, int newData_2001) {
        // buat node baru
    	NodeDLL_2511532001 newNode_2001 = new NodeDLL_2511532001(newData_2001);
        //jika dll null jadikan head
        if (head_2001 == null) {
            head_2001 = newNode_2001;
        }
        else {
        	NodeDLL_2511532001 curr_2001 = head_2001;
        	while (curr_2001.next_2001 != null) {
                curr_2001 = curr_2001.next_2001;
            }
            curr_2001.next_2001 = newNode_2001;
            newNode_2001.prev_2001 = curr_2001;
        }
        return head_2001;
        }
    // fungsi menambahkan node di posisi tertentu
    public static NodeDLL_2511532001 insertAtPosition_2001(NodeDLL_2511532001 head_2001, int pos_2001, int new_data_2001) {
        // buat node baru
        NodeDLL_2511532001 new_node_2001 = new NodeDLL_2511532001(new_data_2001);
        if (pos_2001 == 1) {
            new_node_2001.next_2001 = head_2001;
            if (head_2001 != null) {
                head_2001.prev_2001 = new_node_2001;
            }
            head_2001 = new_node_2001;
            return head_2001;
        }
        NodeDLL_2511532001 curr_2001 = head_2001;
        for (int i_2001 = 1; i_2001 < pos_2001 - 1 && curr_2001 != null; ++i_2001) {
            curr_2001 = curr_2001.next_2001;
        }
        if (curr_2001 == null) {
            System.out.println("Posisi tidak ada");
            return head_2001;
        }
        new_node_2001.prev_2001 = curr_2001;
        new_node_2001.next_2001 = curr_2001.next_2001;
        curr_2001.next_2001 = new_node_2001;
        if (new_node_2001.next_2001 != null) {
        	new_node_2001.next_2001.prev_2001 = new_node_2001; }
        return head_2001;
        }
    public static void PrintList_2511532001(NodeDLL_2511532001 head_2001) {
    	NodeDLL_2511532001 curr_2001 = head_2001;
    	while (curr_2001 != null) {
    		System.out.print(curr_2001.data_2001 + " <-> ");
    		curr_2001 = curr_2001.next_2001;
    	}
    	System.out.println();
    }
    public static void main (String[]args) {
    	NodeDLL_2511532001 head_2001 = new NodeDLL_2511532001(2);
    	head_2001.next_2001 = new NodeDLL_2511532001(3);
    	head_2001.next_2001.prev_2001 = head_2001;
    	head_2001.next_2001.next_2001 = new NodeDLL_2511532001(5);
    	head_2001.next_2001.next_2001.prev_2001 = head_2001.next_2001;
    	// cetak DLL awal
    	System.out.print("DLL awal: ");
    	PrintList_2511532001 (head_2001);
    	// tambah 1 di awal
    	head_2001 = insertBegin_2001(head_2001, 1);
    	System.out.print("Simpul 1 ditambah di awal: ");
    	PrintList_2511532001 (head_2001);
    	// tambah 6 di akhir
    	System.out.print("Simpul 6 ditambah di akhir: ");
    	int data_2001 = 6;
    	head_2001 = insertEnd_2001(head_2001, data_2001);
    	PrintList_2511532001 (head_2001);
    	// menambah node 4 di posisi 4
    	System.out.print("tambah node 4 di posisi 4: ");
    	int data2_2001 = 4;
    	int pos_2001 = 4;
    	head_2001 = insertAtPosition_2001 (head_2001, pos_2001, data2_2001);
    	PrintList_2511532001 (head_2001);

    }
}


