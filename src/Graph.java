import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Graph<E> {
    private boolean[][] edges;
    private E[] labels;

    public Graph(int n) {
        edges = new boolean[n][n];
        labels = (E[]) new Object[n];
    }

    public E getLabel(int vertex) {
        return labels[vertex];
    }

    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    public int[] neighbors(int vertex) {
        int i;
        int count = 0;
        int[] answer;

        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                count++;
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }
    public void removeEdge(int source, int target){
        edges[source][target] = false;
    }
    public void setLabel(int vertex, E newLabel){
        labels[vertex] = newLabel;
    }
    public int size(){
        return labels.length;
    }


    public String breadthFirstTraversal(String root){
        return "";
    }
    public QueueInterface<E> depthFirstTraversal(E origin){
        QueueInterface<E> traversalOrder = new LinkedQueue<E>();
        StackInterface<Integer> vertexStack = new LinkedStack<>();

        traversalOrder.enqueue(origin);
        vertexStack.push(1);

        while(!vertexStack.isEmpty()){
            int topVertex = vertexStack.peek();
            int[] neighbors = neighbors(topVertex);
            int nextNeighbor =



            vertexStack.pop();

        }
        return traversalOrder;
    }

}
