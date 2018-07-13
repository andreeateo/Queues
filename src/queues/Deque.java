package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int count;

    public Deque() {                           // construct an empty deque - linkedList
        first = null;
        last = null;
        count = 0;
    }

    private class Node {

        Item item;
        Node next;
    }

    public boolean isEmpty() {                // is the deque empty?
        return (first == null);
    }

    public int size() {                        // return the number of items on the deque
        return count;
    }

    public void addFirst(Item item) {          // add the item to the front
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (count == 0) {
            first = new Node();
            first.item = item;
            last = first;//
            count++;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;//
            count++;
        }
    }

    public void addLast(Item item) {           // add the item to the end
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (count == 0) {
            first = new Node();
            first.item = item;
            last = first;
            count++;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            oldLast.next = last;//
            count++;
        }
    }

    public Item removeFirst() {                // remove and return the item from the front
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node removed = first;
        if (first.next != null) {
            first = first.next;
        }
        count--;
        return removed.item;
    }

    public Item removeLast() {                 // remove and return the item from the end
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node removed = last;
        Node curr = null;
        if (first == last) {
            first = null;
            last = null;
            count--;
            return removed.item;
        }
        for (curr = first; curr.next.next != null; curr = curr.next) {
        }
        last = curr;
        count--;
        return removed.item;
    }

    @Override
    public Iterator<Item> iterator() {         // return an iterator over items in order from front to end
        Iterator<Item> it = new Iterator<Item>() {
            private Node curr = null;

            @Override
            public boolean hasNext() {
                if (isEmpty() || (curr == last)) {
                    return false;
                }
                return true;
            }

            @Override
            public Item next() {
                if (hasNext()) {
                    if (curr == null) {
                        curr = first;
                    } else {
                        curr = curr.next;
                    }
                    return curr.item;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return it;
    }
}
