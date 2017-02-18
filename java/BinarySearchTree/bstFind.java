/*
	Class to perform key base operations in a BST
*/
class bstFind {

	// return height of the bst
	public int height(Node head) {
	    if (head == null) {
	        return 0;
	    }
	    int leftHeight = height(head.left);
	    int rightHeight = height(head.right);
	    return Math.max(leftHeight, rightHeight) + 1;
	}

	// A function to search a given key in BST
	public String search(Node head, int data) {
	    try {
	    	if (head.data==data)
	    	    return "Key Found";        	
	    	if (head.data > data)
	    	    return search(head.left, data);
	    	return search(head.right, data);
	    }
	    catch(NullPointerException e) {
	    	return "Key not found";
	    }
	}

	//Find the smallest element 
	public Node findSmallest(Node head) {
		if(head == null) {
			return null;
		}
		while(head.left != null) {
			head = head.left;
		}
		return head;
	}

	//Find the largest element 
	public Node findLargest(Node head) {
		if(head == null) {
			return null;
		}
		while(head.right != null) {
			head = head.right;
		}
		return head;
	}

	public static void main(String args[]) {

		bstFind bf = new bstFind();	    
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
	    
	    //Provide key for searching Element
	    // a)key present
	    System.out.println("\n" + bf.search(head, 21));
	    // b)key not present
	    System.out.println("\n" + bf.search(head, 100));

	    //Printing the smallest node
	    System.out.println("\nThe Smallest element is " + bf.findSmallest(head).data);

	    //Printing the largest node
	    System.out.println("\nThe Largest element is " + bf.findLargest(head).data);
	}
}