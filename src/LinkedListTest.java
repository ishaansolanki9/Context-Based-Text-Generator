import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class LinkedListTest {

    @Test
    public void testLinkedListEmpty() {
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.isEmpty(), "List should be empty initially");
    }

    @Test
    public void testAddElementsToLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        assertFalse(list.isEmpty(), "List should not be empty after adding elements");
    }

    @Test
    public void testToArrayList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        ArrayList<String> arrayList = list.toArrayList();
        assertEquals(2, arrayList.size());
        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
    }

    @Test
    public void testRemoveFromEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> list.remove());
    }
}
