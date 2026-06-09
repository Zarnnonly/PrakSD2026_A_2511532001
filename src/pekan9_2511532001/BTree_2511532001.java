package pekan9_2511532001;

public class BTree_2511532001 {
    private Node_2511532001 root_2001;
    private Node_2511532001 currentNode_2001;
    public BTree_2511532001 () {
        root_2001 = null;
    }
    public boolean search_2001(int data_2001) {
        return search_2001(root_2001, data_2001);
    }
    private boolean search_2001(Node_2511532001 node_2001, int data_2001) {
        if (node_2001.getData_2001() == data_2001)
            return true;
        if (node_2001.getLeft_2001() != null)
            if (search_2001(node_2001.getLeft_2001(), data_2001))
                return true;
        if (node_2001.getRight_2001() != null)
            if (search_2001(node_2001.getRight_2001(), data_2001))
                return true;
        return false;
    }
    public void printInorder_2001 () {
        root_2001.printInorder_2001(root_2001);
    }
    public void printPreorder_2001 () {
        root_2001.printPreorder_2001(root_2001);
    }
    public void printPostorder_2001 () {
        root_2001.printPostorder_2001(root_2001);
    }
    public Node_2511532001 getRoot_2001() {
        return root_2001;
    }
    public boolean isEmpty_2001() {
        return root_2001 == null;
    }

    public int countNodes_2001() {
        return countNodes_2001(root_2001);
    }
    private int countNodes_2001(Node_2511532001 node_2001) {
        int count_2001 = 1;
        if (node_2001 == null) {
            return 0;
        } else {
            count_2001 += countNodes_2001(node_2001.getLeft_2001());
            count_2001 += countNodes_2001(node_2001.getRight_2001());
            return count_2001;
        }
    }
    public void print_2001() {
        root_2001.print_2001();
    }
    public Node_2511532001 getCurrentNode_2001() {
        return currentNode_2001;
    }
    public void setCurrentNode_2001(Node_2511532001 node_2001) {
        this.currentNode_2001 = node_2001;
    }
    public void setRoot_2001(Node_2511532001 root_2001) {
        this.root_2001 = root_2001;
    }
    }
