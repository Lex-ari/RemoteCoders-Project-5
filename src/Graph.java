import java.util.ArrayList;
import java.util.Arrays;
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


    public QueueInterface<E> breadthFirstTraversal(E root){
        QueueInterface<E> traversal = new LinkedQueue<E>();
        QueueInterface<E> order = new LinkedQueue<E>();
        
        order.enqueue(root);
        traversal.enqueue(root);
        while(!traversal.isEmpty()){
            E node = traversal.getFront();
            
        }
        

        return order;
    }
    public QueueInterface<E> depthFirstTraversal(E origin){
        QueueInterface<E> traversalOrder = new LinkedQueue<E>();
        StackInterface<Integer> vertexStack = new LinkedStack<>();

        traversalOrder.enqueue(origin);
        int originIndex = -1;
        for (int i = 0; i < labels.length; i++){
            if (origin.equals(labels[i])){
                originIndex = i;
                break;
            }
        }
        vertexStack.push(originIndex);

        ArrayList isVisited = new ArrayList(labels.length);
        if (originIndex >= 0) {
            while (!vertexStack.isEmpty()) {
                int topVertex = vertexStack.peek();
                int[] neighbors = neighbors(topVertex);
                int nextNeighbor = -1;
                for (int g : neighbors) {
                    if (!isVisited.contains(g)) {
                        nextNeighbor = g;
                        break;
                    }
                }

                if (nextNeighbor != -1) {
                    isVisited.add(nextNeighbor);
                    traversalOrder.enqueue(getLabel(nextNeighbor));
                    vertexStack.push(nextNeighbor);
                } else {
                    vertexStack.pop();
                }
            }
        }
        return traversalOrder;
    }

}
