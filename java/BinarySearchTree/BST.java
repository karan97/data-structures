/*
    Binary Search Tree definition
*/
class BST {

    // adds node according to the BST rules
    public Node addNode(int data, Node head) {
        Node tempHead = head;
        Node n = Node.makeNode(data);
        if (head == null) {
            head = n;
            return head;
        }
        Node prev = null;
        while (head != null) {
            prev = head;
            if (head.data < data) {
                head = head.right;
            } else {
                head = head.left;
            }
        }
        if (prev.data < data) {
            prev.right = n;
        } else {
            prev.left = n;
        }
        return tempHead;
    }

    public static void main(String args[]) {
        
        BST bt = new BST();
        Node head = null;
        
        //Adding nodes
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(19, head);
        head = bt.addNode(20, head);
        head = bt.addNode(-1, head);
        head = bt.addNode(21, head);

    }
}
