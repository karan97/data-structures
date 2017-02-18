/*
    Node class for BST
*/

public class Node {

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