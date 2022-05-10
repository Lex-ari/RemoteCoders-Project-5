public interface BasicGraphInterface<T> {

    /**
     * Adds a vertex to the graph with a label
     * @param vertexLabel
     * @return true when error-free
     */
    public boolean addVertex(T vertexLabel);

    /**
     * Adds an "edge" between two vertexes on a graph
     * @param begin
     * @param end
     * @return true when error-free
     */
    public boolean addEdge(T begin, T end);

    /**
     * Checks if there exists an edge betwen two vertexes
     * @param begin
     * @param end
     * @return true if it exists
     */
    public boolean hasEdge(T begin, T end);

    /**
     * @return true if graph is empty
     */
    public boolean isEmpty();

    /**
     * @return number of vertices
     */
    public int getNumberOfVertices();

    /**
     *
     */
    public void clear();
}
