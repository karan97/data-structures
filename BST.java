import java.util.Stack;

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
        	    return "Found " + data;        	
        	if (head.data > data)
        	    return search(head.left, data);
        	return search(head.right, data);
        }
        catch(NullPointerException e) {
        	return "Element not found";
        }
    }

    public void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.data + " ");
        inOrder(head.right);
    }

    public void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

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
        
        //Printing nodes using different traversals
        System.out.println("Inorder (Recursion): ");
        bt.inOrder(head);
        System.out.println("\n Preorder: ");
        bt.preOrder(head);
        System.out.println("\n Postorder: ");
        bt.postOrder(head);

        //Searching Element
        System.out.println("\n" + bt.search(head, 21));

        //Printing without recursion
        System.out.println("Inorder (without Recursion): ");
        bt.inOrderWOrec(head);

        //Printing the smallest node
        System.out.println("\nThe Smallest element is " + bt.findSmallest(head).data);

        //Printing the largest node
        System.out.println("\nThe Largest element is " + bt.findLargest(head).data);
    }
}