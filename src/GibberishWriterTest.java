import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class GibberishWriterTest {

    @Test
    public void testGibberishWriterInitialization() {
        GibberishWriter writer = new GibberishWriter(2);
        assertEquals(2, writer.getContextSize());
    }

    @Test
    public void testAddDataFile() {
        GibberishWriter writer = new GibberishWriter(1);
        writer.addDataFile("test.txt");
        assertFalse(writer.getContextData(0).numOccurrences() == 0, "Context data should be populated.");
    }

    @Test
    public void testGenerateGibberish() {
        GibberishWriter writer = new GibberishWriter(2);
        writer.addDataFile("test.txt");
        StringBuilder gibberish = new StringBuilder();
        int wordCount = 10;
        for (int i = 0; i < wordCount; i++) {
            gibberish.append(writer.next()).append(" ");
        }
        assertFalse(gibberish.toString().isEmpty());
    }
}
