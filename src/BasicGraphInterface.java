public interface BasicGraphInterface<T> {

    /**
     * @param vertexLabel
     * @return
     */
    public boolean addVertex(T vertexLabel);

    /**
     * @param begin
     * @param end
     * @return
     */
    public boolean addEdge(T begin, T end);

    /**
     * @param begin
     * @param end
     * @return
     */
    public boolean hasEdge(T begin, T end);

    /**
     * @return
     */
    public boolean isEmpty();

    /**
     * @return
     */
    public int getNumberOfVertices();

    /**
     *
     */
    public void clear();
}
