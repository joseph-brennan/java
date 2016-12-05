// CorpusTest.java
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
/**
 * Tests for class Corpus.
 * @author  Dr. Jody Paul
 * @version 1.1
 */
public class CorpusTest {
    /** Short test text blob. */
    private TextBlob tb1;
    /** Longer test text blob. */
    private TextBlob tb2;
    /** Multi-line test text blob. */
    private TextBlob tb3;

    /**
     * Initialize test objects.
     */
    @Before
    public void setup() {
        tb1 = new TextBlob("Blob One",
         "Now is the time for all good folks to come to the aid of their party.");
        tb2 = new TextBlob("Blob Two",
                           "Pack my box with five dozen liquor jugs. "
                           + "The quick brown fox jumps over the lazy dog. "
                           + "She sells sea shells by the sea shore. "
                           + "How now brown cow? You don't say!");
        tb3 = new TextBlob("Blob Two",
                           "Pack my box with five dozen liquor jugs.\n"
                           + "The quick brown fox jumps over the lazy dog.\n"
                           + "She sells sea shells by the sea shore.\n"
                           + "How now brown cow? You don't say!\n"
                           + "This sentence is\n"
                           + "  broken into multiple\n"
                           + "lines, and has   \n"
                           + "extra spaces at the beginning and ending\n"
                           + " of some lines. \n"
                           + "That's it for now!");
    }

    /**
     * Invokes constructors and accesses text blobs.
     */
    @Test
    public void constructionAndAccessTest() {
        Corpus corp0 = new Corpus(new String());
        Corpus corp1 = new Corpus(new String("Ima Writer"), tb1);
        Corpus corp2 = new Corpus(new String("Justin Emanuensis"), tb2);
        Collection<TextBlob> ctb = corp0.texts();
        assertEquals(0, ctb.size());
        ctb = corp1.texts();
        assertEquals(1, ctb.size());
        assertTrue(ctb.contains(tb1));
        ctb = corp2.texts();
        assertEquals(1, ctb.size());
        assertTrue(ctb.contains(tb2));
    }

    /**
     * Invokes addText method and accesses text blobs.
     */
    @Test
    public void addTextTest() {
        Corpus corp = new Corpus(new String());
        Collection<TextBlob> ctb = corp.texts();
        assertEquals(0, ctb.size());
        corp.addText(tb1);
        ctb = corp.texts();
        assertEquals(1, ctb.size());
        corp.addText(tb2);
        ctb = corp.texts();
        assertEquals(2, ctb.size());
        corp.addText(tb3);
        ctb = corp.texts();
        assertEquals(3, ctb.size());
        assertTrue(ctb.contains(tb1));
        assertTrue(ctb.contains(tb2));
        assertTrue(ctb.contains(tb3));
    }
}
