
package queues;

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andreea teodor
 */
public class DequeTest {

    public DequeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class Deque.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Deque instance = new Deque();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class Deque.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Deque instance = new Deque();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFirst method, of class Deque.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Deque instance = new Deque();
        for (int i = 0; i < 5; i++) {
            instance.addFirst(i);
        }
        int expResult = 5;
        int result = instance.size();
        assertEquals(expResult, result);
        Object expResult2 = 4;
        Object result2 = instance.removeFirst();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of addLast method, of class Deque.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Deque instance = new Deque();
        for (int i = 0; i < 5; i++) {
            instance.addLast(i);
        }
        int expResult = 5;
        int result = instance.size();
        assertEquals(expResult, result);
        Object expResult2 = 4;
        Object result2 = instance.removeLast();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of removeFirst method, of class Deque.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        Deque instance = new Deque();
        for (int i = 0; i < 5; i++) {
            instance.addFirst(i);
        }
        Object result = instance.removeFirst();
        assertEquals(4, result);
        Object a = instance.removeFirst();
        System.out.println("Should be 3: " + a);
    }

    /**
     * Test of removeLast method, of class Deque.
     */
    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        Deque instance = new Deque();
        try {
            instance.removeLast();
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        //assertEquals(expResult, result);

    }

    /**
     * Test of iterator method, of class Deque.
     */
    @Test
    public void testIterator() throws NoSuchElementException {
        System.out.println("iterator");
        Deque instance = new Deque();
        boolean res = instance.iterator().hasNext();
        assertFalse(res);
        for (Object i : instance) {
            System.out.println(i);
        }
        instance.addFirst(100);
        System.out.println("size after adding 100: " + instance.size());
        instance.removeLast();
        System.out.println("size after removing 100: " + instance.size());
        for (int i = 0; i < 5; i++) {
            instance.addLast(i);
            System.out.println("new size: " + instance.size());
        }
        System.out.println("first item is removed: " + instance.removeFirst());
        for (Object i : instance) {
            System.out.println(i);
        }
        System.out.println("the size of the data structure: "+instance.size());
    }
}
