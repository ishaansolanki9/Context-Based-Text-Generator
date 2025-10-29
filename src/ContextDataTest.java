import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContextDataTest {

    @Test
    public void testContextDataInitialization() {
        Context context = new Context(new String[]{"to", "be"});
        ContextData contextData = new ContextData(context);
        assertEquals(context, contextData.getContext());
        assertEquals(0, contextData.numOccurrences());
    }

    @Test
    public void testAddFollowingWord() {
        Context context = new Context(new String[]{"to", "be"});
        ContextData contextData = new ContextData(context);
        contextData.addFollowingWord("or");
        assertEquals(1, contextData.numOccurrences());
        contextData.addFollowingWord("or");
        assertEquals(2, contextData.numOccurrences());
    }

    @Test
    public void testGetFollowingWord() {
        Context context = new Context(new String[]{"to", "be"});
        ContextData contextData = new ContextData(context);
        contextData.addFollowingWord("or");
        contextData.addFollowingWord("that");
        assertEquals("or", contextData.getFollowingWord(1));
        assertEquals("that", contextData.getFollowingWord(2));
        assertThrows(IndexOutOfBoundsException.class, () -> contextData.getFollowingWord(3));
    }
}
