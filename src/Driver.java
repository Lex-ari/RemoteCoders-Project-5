public class Driver {
    public static void main(String[] args){

        // Let A = 0, B = 1, C = 2, D = 3, E = 4, F = 5, G = 6, H = 7, I = 8

        BasicGraphInterface<Character> arrayGraph = new Graph(9);
        arrayGraph.addVertex('A');
        arrayGraph.addVertex('B');
        arrayGraph.addVertex('C');
        arrayGraph.addVertex('D');
        arrayGraph.addVertex('E');
        arrayGraph.addVertex('F');
        arrayGraph.addVertex('G');
        arrayGraph.addVertex('H');
        arrayGraph.addVertex('I');
        arrayGraph.addEdge('A','B');
        arrayGraph.addEdge('A','D');
        arrayGraph.addEdge('A','E');
        arrayGraph.addEdge('B','E');
        arrayGraph.addEdge('C','B');
        arrayGraph.addEdge('D','G');
        arrayGraph.addEdge('E','F');
        arrayGraph.addEdge('E','H');
        arrayGraph.addEdge('F','C');
        arrayGraph.addEdge('F','H');
        arrayGraph.addEdge('G','H');
        arrayGraph.addEdge('H','I');
        arrayGraph.addEdge('I','F');


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

        QueueInterface<Character> breadthFirstTraversal = ((Graph<Character>) arrayGraph).breadthFirstTraversal('A');
        while (!breadthFirstTraversal.isEmpty()){
            System.out.print(breadthFirstTraversal.dequeue());
        }
        System.out.println();
        QueueInterface<Character> depthFirstTraversal = ((Graph<Character>) arrayGraph).depthFirstTraversal('A');
        while (!depthFirstTraversal.isEmpty()){
            System.out.print(depthFirstTraversal.dequeue());
        }
        System.out.println();
    }
}
