import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.Result;

public class Driver {
    public static void main(String[] args){

        runJUnitTests();

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

        System.out.print("BFS Traversal using arrayGraph = ");
        printQueue(((Graph<Character>) arrayGraph).breadthFirstTraversal('A'));

        System.out.print("DFS Traversal using arrayGraph = ");
        printQueue(((Graph<Character>) arrayGraph).depthFirstTraversal('A'));

        System.out.print("BFS Traversal using adjacencyListGraph = ");
        printQueue(((AdjacencyListGraph<Character>) adjacencyListGraph).breadthFirstTraversal('A'));

        System.out.print("DFS Traversal using adjacencyListGraph = ");
        printQueue(((AdjacencyListGraph<Character>) adjacencyListGraph).depthFirstTraversal('A'));

    }

    public static void printQueue(QueueInterface<Character> queue){
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue());
        }
        System.out.println();
    }

    public static void runJUnitTests(){
        Result result = JUnitCore.runClasses(JunitTesting.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("JUnit Tests: Binary Tree test cases were successful? = " + result.wasSuccessful());
    }
}
