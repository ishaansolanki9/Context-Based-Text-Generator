import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordDataTest {

    @Test
    public void testWordDataInitialization() {
        WordData wordData = new WordData("example");
        assertEquals("example", wordData.getWord());
        assertEquals(1, wordData.getCount());
    }

    @Test
    public void testIncrementCount() {
        WordData wordData = new WordData("example");
        wordData.incrementCount();
        assertEquals(2, wordData.getCount());
    }
}
