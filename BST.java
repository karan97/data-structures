class Node {

    int data;
    Node right;
    Node left;

    public static Node makeNode(int data) {
        Node nn = new Node();
        nn.data = data;
        nn.right = null;
        nn.left = null;
        return nn;
    }
}

class BST {

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

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // A function to search a given key in BST
    public String search(Node root, int data) {
        try {
        	// Base Cases: root is null or key is present at root
        	if (root.data==data)
        	    return "Found";
        	
        	// val is greater than root's data
        	if (root.data > data)
        	    return search(root.left, data);
        	
        	// val is less than root's data
        	return search(root.right, data);
        }
        catch(NullPointerException e) {
        	return "Element not found";
        }
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
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
        //printing nodes using different traversals
        System.out.println("Inorder: ");
        bt.inOrder(head);
        System.out.println("\n Preorder: ");
        bt.preOrder(head);
        System.out.println("\n Postorder: ");
        bt.postOrder(head);
        //Searching Element
        System.out.println("\n"+bt.search(head, 21));
    }
}