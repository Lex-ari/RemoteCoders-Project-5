import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class JunitTesting {
    /*
     *  initialized
     */
    QueueInterface<Character> linkedQueue = new LinkedQueue();
    StackInterface<Character> linkedStack = new LinkedStack();

    @Before
    public void setUp(){
        testClear();
    }

    @Test
    public void testClear(){
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
            fail("Failure: Successfully pop into an empty bag.");
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
    public void testIsEmpty(){
        assertEquals(true, linkedStack.isEmpty());
        linkedStack.push('a');
        assertEquals(false, linkedStack.isEmpty());
    }










    @Test
    void breadthFirstTraversal() {
    }

    @Test
    void depthFirstTraversal() {
    }
}