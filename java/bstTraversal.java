/*
	Contains Traversal Methods for a BST
*/

import java.util.Stack;

class bstTraversal {

	// recursive inorder
	public void inOrder(Node head) {
	    if (head == null) {
	        return;
	    }
	    inOrder(head.left);
	    System.out.print(head.data + " ");
	    inOrder(head.right);
	}

	// recursive preorder
	public void preOrder(Node head) {
	    if (head == null) {
	        return;
	    }
	    System.out.print(head.data + " ");
	    preOrder(head.left);
	    preOrder(head.right);
	}

	// recursive postorder
	public void postOrder(Node head) {
	    if (head == null) {
	        return;
	    }
	    postOrder(head.left);
	    postOrder(head.right);
	    System.out.print(head.data + " ");
	}

	//Inorder traversing without recursion
	public void inOrderWOrec(Node head) {
	    if (head == null) {
	        return;
	    }
	            
	    //keep the nodes in the path that are waiting to be visited
	    Stack<Node> stack = new Stack<Node>();
	    Node node = head;
	     
	    //first node to be visited will be the left one
	    while (node != null) {
	        stack.push(node);
	        node = node.left;
	    }
	     
	    // traverse the tree
	    while (stack.size() > 0) {
	       
	        // visit the top node
	        node = stack.pop();
	        System.out.print(node.data + " ");
	        if (node.right != null) {
	            node = node.right;
	             
	            // the next node to be visited is the leftmost
	            while (node != null) {
	                stack.push(node);
	                node = node.left;
	            }
	        }
	    }
	}

	//Preorder traversing without recursion
	public void preOrderWOrec(Node head) {
	    if(head == null) {
	        return;
	    }
	   
	    //keep the nodes in the path that are waiting to be visited
	    Stack<Node> stack = new Stack<Node>();
	    Node temp = head;
	    
	    //first node to be visited will be the left one
	    while(temp != null) {
	        System.out.print(temp.data + " ");
	        stack.push(temp);
	        temp = temp.left;
	    }

	    // traverse the tree
	    while(stack.size() > 0) {

	        // visit the node
	        temp = stack.pop();
	        if(temp.right != null) {
	            System.out.print(temp.right.data + " ");
	            temp = temp.right;
	            
	            // the next node to be visited is the leftmost
	            while(temp != null) {
	                stack.push(temp);
	                temp = temp.left;
	            }
	        }
	    }
	}

	public static void main(String args[]) {
	    
	    BST bst = new BST();
	    bstTraversal bt = new bstTraversal();
	    Node head = null;
	    
	    //Adding nodes
	    head = bst.addNode(10, head);
	    head = bst.addNode(15, head);
	    head = bst.addNode(5, head);
	    head = bst.addNode(7, head);
	    head = bst.addNode(19, head);
	    head = bst.addNode(20, head);
	    head = bst.addNode(-1, head);
	    head = bst.addNode(21, head);
	    
	    //Inorder
	    System.out.print("Inorder (Recursion): ");
	    bt.inOrder(head);
	    System.out.println();
	    System.out.print("Inorder (without Recursion): ");
	    bt.inOrderWOrec(head);
	    System.out.println();

	    //PreOrder
	    System.out.print("Preorder (Recursion): ");
	    bt.preOrder(head);
	    System.out.println();
	    System.out.print("Preorder (without Recursion): ");
	    bt.preOrderWOrec(head);
	    System.out.println();

	    //PostOrder
	    System.out.print("Postorder (Recursion): ");
	    bt.postOrder(head);
	    System.out.println();
	   
	}
}