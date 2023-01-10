/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * //Virginia Tech Honor Code Pledge:
 * //
 * //As a Hokie, I will conduct myself with honor and integrity at all times.
 * //I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * //-- HaoranXing (HaoranXing)
 * /**
 * Class description
 * 
 * /**
 * /**
 * 
 * @author HaoranXing
 * @version 2022/11/1
 * 
 */
public class ArrayQueueTest extends TestCase {

    private ArrayQueue<String> queue1;
    private ArrayQueue<String> queue2;
    private ArrayQueue<String> queue3;
    private ArrayQueue<String> queue4;
    private ArrayQueue<String> queue5;
    private ArrayQueue<String> queue6;

    /**
     * 
     */
    public void setUp() {
        queue1 = new ArrayQueue<String>(50);
        queue2 = new ArrayQueue<String>(50);
        queue3 = new ArrayQueue<String>(50);
        queue4 = new ArrayQueue<String>(50);
        queue5 = new ArrayQueue<String>(50);
        queue6 = new ArrayQueue<String>(50);
    }


    /**
     * 
     */
    public void testGetters() {

        assertEquals(queue1.getSize(), 0);

    }


    /**
     * 
     */
    public void testIsEmpty() {
        assertEquals(queue1.isEmpty(), true);
    }


    /**
     * 
     */
    public void testEnqueue() {

        assertEquals(queue1.getSize(), 0);
        queue1.enqueue("James");
        assertEquals(queue1.getSize(), 1);

    }


    /**
     * 
     */
    public void testDequeueException() {
        Exception thrown = null;
        try {
            queue1.dequeue();
        }
        catch (Exception e) {
            thrown = e;

        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyQueueException);

    }


    /**
     * 
     */
    public void testDequeue() {
        queue1.enqueue("Jack");
        queue1.enqueue("Rose");
        assertEquals(queue1.dequeue(), "Jack");
    }


    /**
     * 
     */
    public void testGetFrontException() {
        Exception thrown = null;
        try {
            queue1.getFront();
        }
        catch (Exception e) {
            thrown = e;

        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyQueueException);

    }


    /**
     * 
     */
    public void testGetFront() {
        queue1.enqueue("Jack1");
        queue1.enqueue("Jack2");
        queue1.enqueue("Jack3");
        assertEquals(queue1.getFront(), "Jack1");
    }


    /**
     * 
     */
    public void testGetLengthOfUnderlyingArray() {

        assertEquals(queue1.getLengthOfUnderlyingArray(), 21);
    }


    /**
     * 
     */
    public void testClear() {
        assertEquals(queue1.getSize(), 0);
        queue1.enqueue("Jack");
        queue1.enqueue("Rose");
        assertEquals(queue1.getSize(), 2);
        queue1.clear();
        assertEquals(queue1.getSize(), 0);

    }


    /**
     * 
     */
    public void testToArray() {
        Exception thrown = null;
        try {
            queue1.toArray();
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyQueueException);
        queue1.enqueue("Jane");
        assertNotSame(queue1.toArray(), queue1.toArray());

    }


    /**
     * 
     */
    public void testToString() {
        assertEquals(queue1.toString(), "[]");
        queue1.enqueue("Jane Doe A:3 M:2 T:1 Wants: Nars");
        queue1.enqueue("No-Planet Jane Doe A:2 M:5 T:4");
        assertEquals(queue1.toString(), "[Jane Doe A:3 M:2 T:1 Wants:"
            + " Nars, No-Planet Jane Doe A:2 M:5 T:4]");
    }


    /**
     * 
     */
    public void testEqual() {
        queue1.enqueue("Jack");
        queue2.enqueue("Rose");
        queue2.enqueue("Rose");
        queue2.enqueue("Jack");
        queue3.enqueue("Jack");
        queue4.enqueue("Rose");
        queue5.enqueue("Jack");
        queue5.enqueue("Rose");
        queue6.enqueue("other guy");
        assertEquals(queue1.equals(queue1), true);
        assertEquals(queue1.equals(queue2), false);
        assertEquals(queue1.equals(queue3), true);
        assertEquals(queue1.equals(queue4), false);
        assertEquals(queue1.equals(queue5), false);
        assertEquals(queue1.equals(new Object()), false);
        assertEquals(queue1.equals(null), false);
        assertEquals(queue1.equals(queue6), false);
        assertEquals(queue6.equals(queue1), false);
        assertEquals(queue6.equals(queue2), false);
    }
}
