import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContextTest {

    @Test
    public void testContextEquality() {
        Context context1 = new Context(new String[]{"to", "be"});
        Context context2 = new Context(new String[]{"to", "be"});
        assertEquals(context1, context2);
    }

    @Test
    public void testContextComparison() {
        Context context1 = new Context(new String[]{"to", "be"});
        Context context2 = new Context(new String[]{"to", "not"});
        assertTrue(context1.compareTo(context2) < 0);
    }

    @Test
    public void testContextGetWord() {
        Context context = new Context(new String[]{"to", "be"});
        assertEquals("to", context.getWord(0));
        assertEquals("be", context.getWord(1));
        assertThrows(IndexOutOfBoundsException.class, () -> context.getWord(2));
    }
}
