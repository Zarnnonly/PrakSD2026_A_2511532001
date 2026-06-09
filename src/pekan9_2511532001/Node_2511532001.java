package pekan9_2511532001;

public class Node_2511532001 {
    int data_2001;
    Node_2511532001 left_2001;
    Node_2511532001 right_2001;
    public Node_2511532001 (int data_2001) {
        this.data_2001 = data_2001;
        left_2001 = null;
        right_2001 = null;
    }
    public void setLeft_2001 (Node_2511532001 node_2001) {
        if (left_2001 == null)
            left_2001 = node_2001;
    }
    public void setRight_2001 (Node_2511532001 node_2001) {
        if (right_2001 == null)
            right_2001 = node_2001;
    }
    public Node_2511532001 getLeft_2001() {
        return left_2001;
    }
    public Node_2511532001 getRight_2001() {
        return right_2001;
    }
    public int getData_2001() {
        return data_2001;
    }
    public void setData_2001(int data_2001) {
        this.data_2001 = data_2001;
    }

    void printPreorder_2001 (Node_2511532001 node_2001) {
        if (node_2001 == null)
            return;
        System.out.print(node_2001.data_2001 + " ");
        printPreorder_2001(node_2001.left_2001);
        printPreorder_2001(node_2001.right_2001);
    }
    void printPostorder_2001 (Node_2511532001 node_2001) {
        if (node_2001 == null)
            return;
        printPostorder_2001(node_2001.left_2001);
        printPostorder_2001(node_2001.right_2001);
        System.out.print(node_2001.data_2001 + " ");
    }
    void printInorder_2001 (Node_2511532001 node_2001) {
        if (node_2001 == null)
            return;
        printInorder_2001(node_2001.left_2001);
        System.out.print(node_2001.data_2001 + " ");
        printInorder_2001(node_2001.right_2001);
    }
    public String print_2001() {
        return this.print_2001("", true ,"");
    }
    public String print_2001(String prefix_2011, boolean isTail_2011, String sb_2011) {
        if (right_2001 != null ) {
            right_2001.print_2001(prefix_2011 + (isTail_2011 ? "| ": " "), false, sb_2011);
        }
        System.out.println( prefix_2011 + (isTail_2011 ? "\\-- ": "/-- ") + data_2001);
        if (left_2001 != null) {
            left_2001.print_2001(prefix_2011 + (isTail_2011 ? "  ": "| "), true, sb_2011);
        }
        return sb_2011;
    }
}