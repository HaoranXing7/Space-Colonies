/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

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
 * @version 2022/10/29
 * @param <T>
 *            The type of object the class will store
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    /**
     * The default capacity of a queue is 20
     */
    public static final int DEFAULT_CAPACITY = 20;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;

    /**
     * constructor of the class
     * sets up the array queue
     * 
     * @param capacity
     *            of queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        queue = (T[])new Object[capacity + 1];
        size = 0;
        enqueueIndex = queue.length - 1;
        dequeueIndex = 0;
    }


    /**
     * gets length of underlying array
     * 
     * @return int of length
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }


    /**
     * gets size of queue
     * 
     * @return int of size
     */
    public int getSize() {
        return size;
    }


    /**
     * private method to figure out if the queue is full
     * 
     * @return boolean representing if its full
     */
    private boolean isFull() {
        return size == queue.length - 1;
    }


    /**
     * ensures a capacity, if capacity is not
     * of satisfaction it extends the capacity so that
     * it is.
     */
    private void ensureCapacity() {
        if (isFull()) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = oldSize * 2 - 1;
            queue = (T[])new Object[newSize];
            int in = dequeueIndex;
            for (int i = 0; i < oldSize - 1; i++) {
                queue[i] = oldQueue[in];
                in = (in + 1) % oldSize;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }

    }


    /**
     * Increments index
     * 
     * @param index
     *            of focus
     * @return int of index
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * creates an array representing the queue
     * 
     * @return Object[] representing the queue
     */
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] ans = (T[])new Object[this.size];
        int index = dequeueIndex;
        for (int i = 0; i < this.size; i++) {
            ans[i] = queue[index];
            index = incrementIndex(index);
        }
        return ans;
    }


    /**
     * A to string method
     *
     * @return String representing the array queue
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        int index = dequeueIndex;
        StringBuilder ans = new StringBuilder();
        ans.append("[");
        for (int i = 0; i < this.size - 1; i++) {
            ans.append(queue[index].toString());
            ans.append(", ");
            index++;
        }
        ans.append(queue[index]);
        ans.append("]");
        return ans.toString();
    }


    /**
     * compares and object to the array queue
     * 
     * @param obj
     *            of comparison
     * @return boolean representing if they are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == ArrayQueue.class) {
            ArrayQueue o = (ArrayQueue)obj;
            if (this.getSize() != o.getSize()) {
                return false;
            }
            for (int i = 0; i < size; i++) {

                T myElement = queue[(dequeueIndex + i) % queue.length];

                T otherElement = (T)o.queue[(o.dequeueIndex + i)
                    % o.queue.length];

                if (!myElement.equals(otherElement)) {

                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /**
     * overrides clear method to properly clear out
     * the array queue
     */
    @Override
    public void clear() {
        size = 0;
        enqueueIndex = queue.length - 1;
        dequeueIndex = 0;
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];

    }


    /**
     * overrides the dequeue method to properly
     * dequeue the front person in queue.
     */
    @Override
    public T dequeue() {
        if (getSize() == 0) {
            throw new EmptyQueueException("empty");
        }
        T ret = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        size--;
        return ret;
    }


    /**
     * overrides the enqueue method to properly add
     * a new person to the back of the queue.
     */
    @Override
    public void enqueue(T obj) {
        ensureCapacity();

        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = obj;
        size++;

    }


    /**
     * overrides the getFront method to find the first person
     * in the queue
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("empty");
        }
        return queue[dequeueIndex];
    }


    /**
     * overrides the isEmpty method to properly check if
     * the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return dequeueIndex == (enqueueIndex + 1) % queue.length;
    }

}
