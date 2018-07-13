package queues;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author andreea teodor
 */
@RunWith(Parameterized.class)
public class Permutation {

    //Parameterized tests
    private final String fileName;

    @Parameterized.Parameters
    public static List<Object> data() {
        return Arrays.asList("distinct", "duplicates", "mediumTale", "permutation10", "permutation4", "permutation5", "permutation6", "permutation8", "tale", "tinyTale");
    }

    public Permutation(String fileName) {
        this.fileName = fileName;
    }
    
    //this test reads in a sequence of strings and tests weather the RandomizedQueue iterator returns the elements in a random order
    @Test
    public void testCasesFromFile() throws UnsupportedEncodingException {
        InputStream in = getClass().getResourceAsStream("/test/queues/" + fileName + ".txt");
        Reader fr = new InputStreamReader(in, "utf-8");

        RandomizedQueue<String> que = new RandomizedQueue<>();

        assertEquals(que.size(), 0);
        assertTrue(que.isEmpty());
        
        int expectedSize = 0;
        
        ArrayDeque<String> readValues = new ArrayDeque();
        
        Scanner scanner = new Scanner(fr);
        while(scanner.hasNext()){
            String item = scanner.next();
            readValues.push(item);
            que.enqueue(item);
            expectedSize++;
            assertEquals(que.size(), expectedSize);
        }

        if (que.size() > 1) {
            boolean found_not_equal = false;
            
            for (int tries = 0; tries < 100; tries++) {
                Iterator<String> rand_it = que.iterator();
                Iterator<String> it = readValues.iterator();

                while (rand_it.hasNext()) {
                    assertTrue(it.hasNext());

                    String rand_str = rand_it.next();
                    String str = it.next();

                    if (!rand_str.equals(str)) {
                        found_not_equal = true;
                        break;
                    }
                }
            }
            
            assertTrue(found_not_equal);
        }
    }
}
