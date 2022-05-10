import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyListGraph<E> implements BasicGraphInterface<E>{
    private LinkedList<LinkedList<E>> adjacencyList;
    private LinkedList<E>labels;

    public AdjacencyListGraph(int n){
        adjacencyList = new LinkedList();
        labels = new LinkedList();
    }

    @Override
    public boolean addVertex(E vertexLabel) {
        adjacencyList.add(new LinkedList<E>());
        labels.add(vertexLabel);
        return true;
    }


    @Override
    public boolean addEdge(E begin, E end) {
        int index = labels.indexOf(begin);
        adjacencyList.get(index).add(end);
        return true;
    }

    @Override
    public boolean hadEdge(E begin, E end) {
        int index = labels.indexOf(begin);
        if (index != -1){
            return adjacencyList.get(index).indexOf(end) != -1;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    @Override
    public int getNumberOfVertices() {
        return adjacencyList.size();
    }

    @Override
    public void clear() {
        adjacencyList.clear();
        labels.clear();
    }

    public QueueInterface<E> depthFirstTraversal(E origin){
        QueueInterface<E> traversalOrder = new LinkedQueue<E>();
        StackInterface<E> vertexStack = new LinkedStack<E>();

        traversalOrder.enqueue(origin);
        vertexStack.push(origin);

        ArrayList isVisited = new ArrayList(labels.size());
        if (origin != null) {
            while (!vertexStack.isEmpty()) {
                E topVertex = vertexStack.peek();
                LinkedList<E> neighbors = adjacencyList.get(labels.indexOf(topVertex));
                E nextNeighbor = null;
                for (E g : neighbors) {
                    if (!isVisited.contains(g)) {
                        nextNeighbor = g;
                        break;
                    }
                }

                if (nextNeighbor != null) {
                    isVisited.add(nextNeighbor);
                    traversalOrder.enqueue(nextNeighbor);
                    vertexStack.push(nextNeighbor);
                } else {
                    vertexStack.pop();
                }
            }
        }
        return traversalOrder;
    }
}
