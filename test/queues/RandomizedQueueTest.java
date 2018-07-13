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
public class RandomizedQueueTest {

    public RandomizedQueueTest() {
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
     * Test of isEmpty method, of class RandomizedQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        RandomizedQueue instance = new RandomizedQueue();
        boolean result = instance.isEmpty();
        assertEquals(true, result);
    }

    /**
     * Test of size method, of class RandomizedQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        RandomizedQueue instance = new RandomizedQueue();
        int result = instance.size();
        assertEquals(0, result);
        for (int i = 0; i < 4; i++) {
            instance.enqueue(i);
        }
        int res = instance.size();
        assertEquals(4, res);
    }

    /**
     * Test of enqueue method, of class RandomizedQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.print("enqueue: ");
        Object item = null;
        RandomizedQueue instance = new RandomizedQueue();
        try {
            instance.enqueue(item);
        } catch (IllegalArgumentException e) {
        }
        for (int i = 0; i < 10; i++) {
            instance.enqueue(i);
        }
        Integer a = (Integer) instance.sample();
        System.out.println("the sample is: " + a);
        assertTrue(a instanceof Integer);
    }

    /**
     * Test of dequeue method, of class RandomizedQueue.
     */
    @Test
    public void testDequeue() {
        System.out.print("dequeue: ");
        RandomizedQueue instance = new RandomizedQueue();
        try {
            Object result = instance.dequeue();
        } catch (NoSuchElementException e) {
        }
        for (int i = 0; i < 10; i++) {
            instance.enqueue(i);
        }
        Integer a = (Integer) instance.dequeue();
        System.out.println("the dequeued element is: " + a);
        assertEquals(9, instance.size());
    }

    /**
     * Test of sample method, of class RandomizedQueue.
     */
    @Test
    public void testSample() {
        System.out.print("sample: ");
        RandomizedQueue instance = new RandomizedQueue();
        for (int i = 0; i < 10; i++) {
            instance.enqueue(i);
        }
        Integer a = (Integer) instance.sample();
        System.out.println("the sample is: " + a);
        assertTrue(a instanceof Integer);
    }

    /**
     * Test of iterator method, of class RandomizedQueue.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        RandomizedQueue instance = new RandomizedQueue();

        for (int i = 0; i < 10; i++) {
            instance.enqueue(i);
        }
        for (Object i : instance) {
            System.out.println(i);
        }
    }
}
