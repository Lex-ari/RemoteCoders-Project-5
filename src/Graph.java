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
    public int getVertex(E label){
        int vertex = -1;
        for(int i = 0; i < labels.length; i++){
            if(labels[i].equals(label)){
                vertex = i;
                break;
            }
        }
        return vertex;
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


    public QueueInterface<Integer> breadthFirstTraversal(E origin){
        QueueInterface<Integer> traversal = new LinkedQueue<Integer>();
        QueueInterface<Integer> order = new LinkedQueue<Integer>();
        int[] usedValues = new int[this.size()];
        int temp = 0;
        boolean duplicate = false;
        order.enqueue(this.getVertex(origin));
        traversal.enqueue(this.getVertex(origin));
        while(!traversal.isEmpty()){
            int node = traversal.getFront();
            traversal.dequeue();
            int[] neighbors = this.neighbors(node);
            for(int i = 0; i < neighbors.length; i++){
                for(int j = 0; j < neighbors.length; j++){
                    temp = neighbors[i];
                    if(neighbors[j] < temp){
                        temp = neighbors[j];
                    }
                }
                for(int k = 0; k < usedValues.length; k++){
                    if(neighbors[temp] == usedValues[k]){
                        duplicate = true;
                    }
                }
                if(!duplicate){
                    order.enqueue(temp);
                    traversal.enqueue(temp);

                    neighbors[temp] = Integer.MAX_VALUE;
                }
            }

        }
        return order;
    }
    public QueueInterface<E> depthFirstTraversal(E origin){
        QueueInterface<E> traversalOrder = new LinkedQueue<E>();
        StackInterface<Integer> vertexStack = new LinkedStack<>();

        traversalOrder.enqueue(origin);
        int originIndex = getVertex(origin);
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
