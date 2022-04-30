public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode;
    private Node lastNode;
    public LinkedQueue(){
        firstNode = null;
        lastNode = null;
    }

    private class Node{
        private T data;
        private Node next;




        public T getData(){
            return data;
        }

        public void setData(T newData){
            data = newData;
        }

        public Node getNextNode(){
            return next;
        }

        public void setNextNode(Node newNode){
            next = newNode;
        }
    }


    @Override
    public void enqueue(T newEntry) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T getFront() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
