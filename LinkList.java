class Node{
    int data;
    Node next;
    
    public static Node newNode(int data){
        Node n = new Node();
        n.data = data;
        n.next = null;
        return n;
    }
}

class LinkList {
    
    public Node addNode(int data, Node head, Object... obj){
        Node temp = head;
        Node n = null;
        n = Node.newNode(data);
        if(head == null){
            return n;
        }
        while(head.next != null){
            head = head.next;
        }
        head.next = n;
        return temp;
    }
    
    public void printList(Node head){
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String args[]){
        LinkList ll = new LinkList();
        Node head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);
        head = ll.addNode(6, head);
        ll.printList(head);
    }
}
