import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

abstract class JunitTesting {
    /*
     *  initialized
     */
    QueueInterface<Character> linkedQueue = new LinkedQueue();
    StackInterface<Character> linkedStack = new LinkedStack();
    BasicGraphInterface<Character> arrayGraph = new Graph();
        arrayGraph.addVertex('A');
        arrayGraph.addVertex('B');
        arrayGraph.addVertex('C');
        arrayGraph.addVertex('D');
        arrayGraph.addVertex('E');
        arrayGraph.addVertex('F');
        arrayGraph.addVertex('G');
        arrayGraph.addVertex('H');
        arrayGraph.addVertex('I');
        arrayGraph.addEdge('A','B');
        arrayGraph.addEdge('A','D');
        arrayGraph.addEdge('A','E');
        arrayGraph.addEdge('B','E');
        arrayGraph.addEdge('C','B');
        arrayGraph.addEdge('D','G');
        arrayGraph.addEdge('E','F');
        arrayGraph.addEdge('E','H');
        arrayGraph.addEdge('F','C');
        arrayGraph.addEdge('F','H');
        arrayGraph.addEdge('G','H');
        arrayGraph.addEdge('H','I');
        arrayGraph.addEdge('I','F');

    BasicGraphInterface<Character> adjacencyListGraph = new AdjacencyListGraph<>(9);
        adjacencyListGraph.addVertex('A');
        adjacencyListGraph.addVertex('B');
        adjacencyListGraph.addVertex('C');
        adjacencyListGraph.addVertex('D');
        adjacencyListGraph.addVertex('E');
        adjacencyListGraph.addVertex('F');
        adjacencyListGraph.addVertex('G');
        adjacencyListGraph.addVertex('H');
        adjacencyListGraph.addVertex('I');
        adjacencyListGraph.addEdge('A','B');
        adjacencyListGraph.addEdge('A','D');
        adjacencyListGraph.addEdge('A','E');
        adjacencyListGraph.addEdge('B','E');
        adjacencyListGraph.addEdge('C','B');
        adjacencyListGraph.addEdge('D','G');
        adjacencyListGraph.addEdge('E','F');
        adjacencyListGraph.addEdge('E','H');
        adjacencyListGraph.addEdge('F','C');
        adjacencyListGraph.addEdge('F','H');
        adjacencyListGraph.addEdge('G','H');
        adjacencyListGraph.addEdge('H','I');
        adjacencyListGraph.addEdge('I','F');



    @Before
    public void setUp(){
        testStackClear();
        testQueueClear();
    }

    /*
     * JunitTest for LinkedStack
     */

    @Test
    public void testStackClear(){
        linkedStack.clear();
        assertEquals(true, linkedStack.isEmpty());
        linkedStack.push('a');
        linkedStack.clear();
        assertEquals(true, linkedStack.isEmpty());
    }
    @Test
    public void testPush(){
        try {
            linkedStack.push('a');
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
        try {
            linkedStack.push('b');
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
        try {
            linkedStack.push(null);
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
    }
    @Test
    public void testPop(){
        try {
            linkedStack.pop();
            fail("Failure: Successfully pop into an empty stack.");
        } catch (EmptyStackException e){
            assertEquals(EmptyStackException.class, e.getClass());
        }
        linkedStack.push('a');
        linkedStack.push('b');
        assertEquals('b', linkedStack.pop());
        assertEquals('a', linkedStack.pop());
    }
    @Test
    public void testPeek(){
        try {
            linkedStack.peek();
            fail("Failure: Successfully peeked into an empty bag.");
        } catch (EmptyStackException e){
            assertEquals(EmptyStackException.class, e.getClass());
        }
        linkedStack.push('a');
        assertEquals('a', linkedStack.peek());
    }
    @Test
    public void testStackIsEmpty(){
        assertEquals(true, linkedStack.isEmpty());
        linkedStack.push('a');
        assertEquals(false, linkedStack.isEmpty());
    }
    /*
     * JunitTest for Queue
     */

    @Test
    public void testQueueClear(){
        linkedQueue.clear();
        assertEquals(true, linkedQueue.isEmpty());
        linkedQueue.enqueue('a');
        linkedQueue.clear();
        assertEquals(true, linkedQueue.isEmpty());
    }
    @Test
    public void testEnqueue(){
        try{
            linkedQueue.enqueue('a');
        }catch (Exception b){
            fail("Failure: enqueue() threw an exception: " + b);
        }
        try{
            linkedQueue.enqueue(null);
        }catch(Exception b){
            fail("Failure: enqueue() threw an exception: " + b);
        }
    }
    @Test
    public void testDequeue(){
        try{
            linkedQueue.dequeue();
            fail("Failure: successfully dequeue() from the linkedQueue");
        }catch(NoSuchElementException e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        linkedQueue.enqueue('a');
        linkedQueue.enqueue('b');
        assertEquals('a', linkedQueue.dequeue());
        assertEquals('b', linkedQueue.dequeue());
    }
    @Test
    public void testGetFront(){
        try{
            linkedQueue.getFront();
            fail("Failure: successfully getFront() from the linkedQueue");
        }catch(NoSuchElementException e){
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        linkedQueue.enqueue('a');
        linkedQueue.enqueue('b');
        assertEquals('a', linkedQueue.getFront());
    }

    @Test
    public void testQueueIsEmpty(){
        assertEquals(true, linkedQueue.isEmpty());
        linkedQueue.enqueue('a');
        assertEquals(false, linkedQueue.isEmpty());
    }





    @Test
    public void testBreadthFirstTraversal() {
       assertEquals("ABDEGFHCI", arrayGraph.breadthFirstTraversal);
       assertEquals("ABDEGFHCI", adjacencyListGraph.breadthFirstTraversal );



    }

    @Test
    public void testDepthFirstTraversal() {
        assertEquals("ABEFCHIDG", arrayGraph.depthFirstTraversal);
        assertEquals("ABEFCHIDG", adjacencyListGraph.depthFirstTraversal);
    }
}


