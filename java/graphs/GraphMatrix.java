/*
* Representation of Undirected Graph using Adjacency Matrix
*/
class GraphMatrix {

    public int vertices;
    public boolean[][] graph;

    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        graph = new boolean[vertices][vertices];
    }

    public void addEdge(int a, int b) {
        graph[a][b] = true;
        graph[b][a] = true;
    }

    public void printGraph() {
        for(int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for(int j = 0; j < vertices; j++) {
                if(graph[i][j]) {
                    System.out.print(j  + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphMatrix graphMatrix = new GraphMatrix(5);
        graphMatrix.addEdge(0, 1);
        graphMatrix.addEdge(0, 2);
        graphMatrix.addEdge(0, 3);
        graphMatrix.addEdge(0, 4);
        graphMatrix.addEdge(1, 2);
        graphMatrix.addEdge(1, 4);
        graphMatrix.addEdge(3, 4);
        graphMatrix.addEdge(3, 2);
        graphMatrix.printGraph();
    }
}