/*
	Question - find K'th Smallest & K'th Largest element in the BST.
	
	Example - So if the BST has elements 1, 2, 44, 55, 100 & 8095 and k(for largest) is 3, it returns 55. If k(for smallest) is 3, it returns 44.
	
*/

import java.util.ArrayList;

class KthElement {

	ArrayList<Integer> al = new ArrayList<Integer>();

	//printing elements using inorder traversal
	public void inOrder(Node head) {
	    if (head == null) {
	        return;
	    }
	    inOrder(head.left);
	    al.add(head.data);
	    inOrder(head.right);
	}

	//using recursive inorder traversal
	public String KthSmallest(int key) {
		return "The K'th Smallest element is " + al.get(key - 1);
	}

	//using recursive reverse inorder traversal
	public String KthLargest(int key) {
		int size = al.size(); //Note - size is total length of arraylist
		return "The K'th Largest element is " + al.get(size - key);
	}

	//arraylist printer function
	public void printArrayList() {
		System.out.print("Inorder traversal: ");
		for(Integer a : al) {
			System.out.print(a + " ");
		}
	}

	public static void main(String args[]) {

		KthElement kth = new KthElement();
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
	
		//using inorder traversal
		kth.inOrder(head);
		
		//printing the arraylist
		kth.printArrayList();
		System.out.println();

		//kth smallest
		System.out.println(kth.KthSmallest(4));

		//kth largest
		System.out.println(kth.KthLargest(3));
	
	}
}