import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class LLIteratorTest {

    @Test
    public void testAddBefore() {
        LinkedList<String> list = new LinkedList<>();
        LLIterator<String> iterator = list.iterator();
        list.add("second");
        iterator.next();
        iterator.addBefore("first");
        assertEquals("first", list.get(0));
    }

    @Test
    public void testAddAfter() {
        LinkedList<String> list = new LinkedList<>();
        LLIterator<String> iterator = list.iterator();
        list.add("first");
        iterator.next();
        iterator.addAfter("second");
        assertEquals("second", list.get(1));
    }

    @Test
    public void testNextOnEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        LLIterator<String> iterator = list.iterator();
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }
}
