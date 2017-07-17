/*
*   Breadth First Traversal of Graph
*/
import java.util.*;

class Graph {

    int vertices, temp;
    LinkedList<Integer>[] list;
    Queue<Integer> queue;
    boolean[] visited;
    Iterator itr;

    public Graph(int vertices) {
        this.vertices = vertices;
        list = new LinkedList[vertices];
        queue = new LinkedList<Integer>();
        visited = new boolean[vertices];
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

    public void bfs(int a) {
        System.out.print("Breadth first traversal: \n" + a + " -> ");
        itr = list[a].iterator();
        visited[a] = true;
        while(itr.hasNext()) {
            temp = (int) itr.next();
            System.out.print(temp + " ");
            queue.add(temp);
            visited[temp] = true;
        }
        while(!queue.isEmpty()) {
            temp = queue.remove();
            visited[temp] = true;
            itr = list[temp].iterator();
            while(itr.hasNext()) {
                temp = (int) itr.next();
                if(!visited[temp]) {
                    System.out.print(temp + " ");
                    visited[temp] = true;
                }
            }
        }
    }
}

class BFS {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);
        graph.addEdge(4, 5);
        graph.printGraph();
        graph.bfs(3);
    }
}