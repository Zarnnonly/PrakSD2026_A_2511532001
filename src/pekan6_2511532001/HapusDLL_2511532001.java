package pekan6_2511532001;

public class HapusDLL_2511532001 {
    // fungsi menghapus node awal
    public static NodeDLL_2511532001 delHead_2001(NodeDLL_2511532001 head_2001) {
        if (head_2001 == null) {
            return null;
        }
        NodeDLL_2511532001 temp_2001 = head_2001;
        head_2001 = head_2001.next_2001;
        if (head_2001 != null) {
            head_2001.prev_2001 = null;
        }
        return head_2001;
    }

    // fungsi menghapus di akhir
    public static NodeDLL_2511532001 delLast_2001(NodeDLL_2511532001 head_2001) {
        if (head_2001 == null) {
            return null;
        }
        if (head_2001.next_2001 == null) {
            return null;
        }
        NodeDLL_2511532001 curr_2001 = head_2001;
        while (curr_2001.next_2001 != null) {
            curr_2001 = curr_2001.next_2001;
        }
        // update pointer previous node
        if (curr_2001.prev_2001 != null) {
            curr_2001.prev_2001.next_2001 = null;
        }
        return head_2001;
    }
  //fungsi menghapus node posisi tertentu
    public static NodeDLL_2511532001 delPos_2001(NodeDLL_2511532001 head_2001, int pos_2001) {
        // jika DLL kosong
        if (head_2001 == null) {
            return head_2001;
        }
        NodeDLL_2511532001 curr_2001 = head_2001;
        // telusuri sampai ke node yang akan dihapus
        for (int i_2001 = 1; curr_2001 != null && i_2001 < pos_2001; ++i_2001) {
            curr_2001 = curr_2001.next_2001;
        }
        // jika posisi tidak ditemukan
        if (curr_2001 == null) {
            return head_2001;
        }
        // Update pointer
        if (curr_2001.prev_2001 != null) {
            curr_2001.prev_2001.next_2001 = curr_2001.next_2001;
        }
        if (curr_2001.next_2001 != null) {
            curr_2001.next_2001.prev_2001 = curr_2001.prev_2001;
        }
        //jika yang dihapus head
        if (head_2001 == curr_2001) {
            head_2001 = curr_2001.next_2001;
        }
        return head_2001;
    }
    
    // fungsi mencetak DLL
    public static void printList_2001(NodeDLL_2511532001 head_2001) {
        NodeDLL_2511532001 curr_2001 = head_2001;
        while (curr_2001 != null) {
            System.out.print(curr_2001.data_2001 + " <-> ");
            curr_2001 = curr_2001.next_2001;
        }
        System.out.println();
    }
    public static void main(String[]args) {
        // buat sebuah DLL
        NodeDLL_2511532001 head_2001 = new NodeDLL_2511532001(1);
        head_2001.next_2001 = new NodeDLL_2511532001(2);
        head_2001.next_2001.prev_2001 = head_2001;
        head_2001.next_2001.next_2001 = new NodeDLL_2511532001(3);
        head_2001.next_2001.next_2001.prev_2001 = head_2001.next_2001;
        head_2001.next_2001.next_2001.next_2001 = new NodeDLL_2511532001(4);
        head_2001.next_2001.next_2001.next_2001.prev_2001 = head_2001.next_2001.next_2001;
        head_2001.next_2001.next_2001.next_2001.next_2001 = new NodeDLL_2511532001(5);
        head_2001.next_2001.next_2001.next_2001.next_2001.prev_2001 = head_2001.next_2001.next_2001.next_2001;

        System.out.print("DLL Awal: ");
        printList_2001(head_2001);

        System.out.print("Setelah head dihapus: ");
        head_2001 = delHead_2001(head_2001);
        printList_2001(head_2001);

        System.out.print("Setelah node terakhir dihapus: ");
        head_2001 = delLast_2001(head_2001);
        printList_2001(head_2001);

        System.out.print("menghapus node ke 2: ");
        head_2001 = delPos_2001(head_2001, 2);

        printList_2001(head_2001);
    }
}
