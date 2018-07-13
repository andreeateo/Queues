package queues;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] q;
    private int n;

    public RandomizedQueue() {                 // construct an empty randomized queue - Resizing Array
        q = (Item[]) new Object[8];
        n = 0;

    }

    public boolean isEmpty() {                 // is the randomized queue empty?
        return n == 0;
    }

    public int size() {                        // return the number of items on the randomized queue
        return n;
    }

    public void enqueue(Item item) {           // add the item
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (n == q.length) {
            Item[] temp = (Item[]) new Object[2 * q.length];
            for (int i = 0; i < n; i++) { //or arraycopy
                temp[i] = q[i];
            }
            q = temp;
        }
        q[n++] = item;
    }

    public Item dequeue() {                    // remove and return a random item
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        int randomIndex = StdRandom.uniform(n);
        Item item = q[randomIndex];
        q[randomIndex] = q[n - 1];
        q[n - 1] = null;
        n--;
        if (n > 0 && n == q.length / 4) {
            Item[] temp = (Item[]) new Object[q.length / 2];
            for (int i = 0; i < n; i++) { //or arraycopy
                temp[i] = q[i];
            }
            q = temp;
        }
        return item;
    }

    public Item sample() {                     // return a random item (but do not remove it)
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        int randomSample = StdRandom.uniform(n);
        return q[randomSample];
    }

    public Iterator<Item> iterator() {        // return an independent iterator over items in random order
        return new randomArrayIterator();
    }

    private class randomArrayIterator implements Iterator<Item> {

        private int i = 0;
        Item[] temp = (Item[]) new Object[n];

        public randomArrayIterator() {
            System.arraycopy(q, 0, temp, 0, n);
            StdRandom.shuffle(temp);
        }

        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            return i < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return temp[i++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported.");
        }
    }
}
