
import java.util.NoSuchElementException;
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

        private Node(T dataPortion){
            this(dataPortion, null);
        }
        
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }

        private T getData(){
            return data;
        }

        private void setData(T newData){
            data = newData;
        }

        private Node getNextNode(){
            return next;
        }
        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }


    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);


        if(isEmpty()){
            firstNode = newNode;
        }
        else{
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        T front = getFront();

        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if(firstNode == null){
            lastNode = null;
        }

        return front;
    }

    @Override
    public T getFront() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return firstNode.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        if(firstNode == null && lastNode == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }
}
