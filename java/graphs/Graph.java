/*
* Representation of Undirected Graph using Adjacency Lists
*/
import java.util.*;

class Graph {

    int vertices;
    LinkedList<Integer>[] list;

    public Graph(int vertices) {
        this.vertices = vertices;
        list = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int a, int b) {
        list[a].add(b);
        list[b].add(a);
    }

    public void printGraph() {
        Iterator itr;
        for(int i = 0; i < vertices; i++) {
            itr = list[i].iterator();
            System.out.print(i + " - > ");
            while(itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);
        graph.printGraph();
    }
}