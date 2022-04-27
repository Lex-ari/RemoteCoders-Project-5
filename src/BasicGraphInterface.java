public interface BasicGraphInterface<T> {
    public boolean addVertex(T vertexLabel);

    public boolean addEdge(T begin, T end, double edgeWeight);

    public boolean addEdge(T begin, T end);

    public boolean hadEdge(T begin, T end);

    public boolean isEmpty();

    public int getNumberOfVertices();

    public void clear();
}
