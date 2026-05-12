package pekan6_2511532001;

public class PenelusuranDLL_2511532001 {
    //fungsi penelusuran maju
    static void forwardTraversal_2001(NodeDLL_2511532001 head_2001) {
        // mulai penelusuran dari head
        NodeDLL_2511532001 curr_2001 = head_2001;
        //lanjutkan sampai akhir
        while (curr_2001 != null) {
            //print data
            System.out.print(curr_2001.data_2001 + " <-> ");
            //pindah ke node berikutnya
            curr_2001 = curr_2001.next_2001;
        }
        //print spasi
        System.out.println();
    }

    // fungsi penelusuran mundur
    static void backwardTraversal_2001(NodeDLL_2511532001 tail_2001) {
        // mulai dari akhir
        NodeDLL_2511532001 curr_2001 = tail_2001;
        //lanjut sampai head
        while (curr_2001 != null) {
            //cetak data
            System.out.print(curr_2001.data_2001 + " <-> ");
            // pindah ke node sebelumnya
            curr_2001 = curr_2001.prev_2001;
        }
        // cetak spasi
        System.out.println();
    }
    public static void main (String[]args) {
    	// cetak DLL
    	NodeDLL_2511532001 head_2001 = new NodeDLL_2511532001(1);
    	NodeDLL_2511532001 second_2001 = new NodeDLL_2511532001(2);
    	NodeDLL_2511532001 third_2001 = new NodeDLL_2511532001(3);
    	
    	head_2001.next_2001 = second_2001;
    	second_2001.prev_2001 = head_2001;
    	second_2001.next_2001 = third_2001;
    	third_2001.prev_2001 = second_2001;
    	
    	System.out.println("Penelusuran maju: ");
    	forwardTraversal_2001(head_2001);
    	
    	System.out.println("Penelusuran mundur: ");
    	backwardTraversal_2001(third_2001);



    }
}