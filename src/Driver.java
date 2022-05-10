public class Driver {
    public static void main(String[] args){

        // Let A = 0, B = 1, C = 2, D = 3, E = 4, F = 5, G = 6, H = 7, I = 8

        Graph graph = new Graph(9);
        graph.setLabel(0,'A');
        graph.setLabel(1,'B');
        graph.setLabel(2,'C');
        graph.setLabel(3,'D');
        graph.setLabel(4,'E');
        graph.setLabel(5,'F');
        graph.setLabel(6,'G');
        graph.setLabel(7,'H');
        graph.setLabel(8,'I');

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);
        graph.addEdge(5, 7);
        graph.addEdge(5, 2);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 5);


        BasicGraphInterface<Character> adjacencyListGraph = new AdjacencyListGraph<>(9);
        adjacencyListGraph.addVertex('A');
        adjacencyListGraph.addVertex('B');
        adjacencyListGraph.addVertex('C');
        adjacencyListGraph.addVertex('D');
        adjacencyListGraph.addVertex('E');
        adjacencyListGraph.addVertex('F');
        adjacencyListGraph.addVertex('G');
        adjacencyListGraph.addVertex('H');
        adjacencyListGraph.addVertex('I');
        adjacencyListGraph.addEdge('A','B');
        adjacencyListGraph.addEdge('A','D');
        adjacencyListGraph.addEdge('A','E');
        adjacencyListGraph.addEdge('B','E');
        adjacencyListGraph.addEdge('C','B');
        adjacencyListGraph.addEdge('D','G');
        adjacencyListGraph.addEdge('E','F');
        adjacencyListGraph.addEdge('E','H');
        adjacencyListGraph.addEdge('F','C');
        adjacencyListGraph.addEdge('F','H');
        adjacencyListGraph.addEdge('G','H');
        adjacencyListGraph.addEdge('H','I');
        adjacencyListGraph.addEdge('I','F');

        QueueInterface<Character> breadthFirstTraversal = ((AdjacencyListGraph<Character>) adjacencyListGraph).breadthFirstTraversal('A');
        while (!breadthFirstTraversal.isEmpty()){
            System.out.print(breadthFirstTraversal.dequeue());
        }
        System.out.println();
        QueueInterface<Character> depthFirstTraversal = ((AdjacencyListGraph<Character>) adjacencyListGraph).depthFirstTraversal('A');
        while (!depthFirstTraversal.isEmpty()){
            System.out.print(depthFirstTraversal.dequeue());
        }
        System.out.println();
    }
}
