package pekan9_2511532001;

public class BtreeDriver_2511532001 {
    public static void main(String[] args) {
        // Membuat pohon
    	BTree_2511532001 tree_2001 = new BTree_2511532001();
        System.out.print("Jumlah Simpul awal pohon: ");
        System.out.println(tree_2001.countNodes_2001());

        // Menambahkan simpul data 1
        Node_2511532001 root_2001 = new Node_2511532001(1);

        //Menjadikan simpul 1 sebagai root
        tree_2001.setRoot_2001(root_2001);
        System.out.print("Jumlah simpul jika hanya ada root");
        System.out.print(tree_2001.countNodes_2001());
        Node_2511532001 node2 = new Node_2511532001(2);
        Node_2511532001 node3 = new Node_2511532001(3);
        Node_2511532001 node4 = new Node_2511532001(4);
        Node_2511532001 node5 = new Node_2511532001(5);
        Node_2511532001 node6 = new Node_2511532001(6);
        Node_2511532001 node7 = new Node_2511532001(7);
        Node_2511532001 node8 = new Node_2511532001(8);
        Node_2511532001 node9 = new Node_2511532001(9);
        root_2001.setLeft_2001(node2);
        node2.setLeft_2001(node4);
        node2.setRight_2001(node5);
        node4.setRight_2001(node8);
        root_2001.setRight_2001(node3);
        node3.setLeft_2001(node6);
        node3.setRight_2001(node7);
        node6.setLeft_2001(node9);
        // Set root
        tree_2001.setCurrentNode_2001(tree_2001.getRoot_2001());
        System.out.println("menampilkan simpul terakhir: ");
        System.out.println(tree_2001.getCurrentNode_2001().getData_2001());
        System.out.println("Jumlah simpul; setelah simpul 7 ditambahkan");
        System.out.println(tree_2001.countNodes_2001());
        System.out.println("InOrder: ");
        tree_2001.printInorder_2001();
        System.out.println("\nPreorder: ");
        tree_2001.printPreorder_2001();
        System.out.println("\nPostorder : ");
        tree_2001.printPostorder_2001();
        System.out.println("\nDmenampilkan simpul dalam bentuk pohon");
        tree_2001.print_2001();
    }
}
