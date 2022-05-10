import java.util.ArrayList;

public class Graph<E> implements BasicGraphInterface<E>{
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
            if(labels[i] != null && labels[i].equals(label)){
                vertex = i;
                break;
            }
        }
        return vertex;
    }

    @Override
    public boolean addVertex(E label){
        final E[] copiedLabels = (E[]) new Object[labels.length + 1];
        final boolean[][] copiedEdges = new boolean[edges.length+1][edges.length+1];
        System.arraycopy(labels, 0, copiedLabels, 0, labels.length);
        copiedLabels[labels.length] = label;
        labels = copiedLabels;

        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < edges.length; j++){
                copiedEdges[i][j] = edges[i][j];
            }
        }
        edges = copiedEdges;
        return true;
    }
    @Override
    public boolean hasEdge(E begin, E end){
        int beginIndex = this.getVertex(begin);
        int endIndex = this.getVertex(end);
        return edges[beginIndex][endIndex];
    }

    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    @Override
    public boolean addEdge(E source, E target) {
        int sourceIndex = this.getVertex(source);
        int targetIndex = this.getVertex(target);
        edges[sourceIndex][targetIndex] = true;
        return true;
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
    public int getNumberOfVertices(){
        return labels.length;
    }
    public void clear(){
        for(int i = 0; i < labels.length; i++){
            labels[i] = null;
        }
        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < edges.length; j++){
                edges[i][j] = false;
            }
        }
    }
    public boolean isEmpty(){
        for(int i = 0; i < labels.length; i++){
            if(labels[i] != null){
                return false;
            }
        }
        return true;
    }

    /**
     * breadthFirstTraversal. Traverses through a graph as a BFS.
     * @param origin, origin node
     * @return a Queue of the nodes visited.
     */
    public QueueInterface<E> breadthFirstTraversal(E origin){
        QueueInterface<Integer> traversal = new LinkedQueue<Integer>();
        QueueInterface<E> order = new LinkedQueue<E>();
        boolean[] usedValues = new boolean[labels.length];
        int temp = 0;
        boolean duplicate = false;
        order.enqueue(origin);
        traversal.enqueue(this.getVertex(origin));
        usedValues[this.getVertex(origin)] = true;

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
                if(!usedValues[temp]){
                    order.enqueue(getLabel(temp));
                    traversal.enqueue(temp);
                    usedValues[temp] = true;
                }
            }

        }
        return order;
    }

    /**
     * depthFirstTraversal. Traverses through a graph as a DFS.
     * @param origin, origin node
     * @return a Queue of the nodes visited.
     */
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
                        if (g < nextNeighbor || nextNeighbor == -1){
                            nextNeighbor = g;
                        }
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