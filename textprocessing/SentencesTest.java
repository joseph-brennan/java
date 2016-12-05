import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
/**
 * Test for Sentences.
 *
 * @author  Dr. Jody Paul
 * @version 1.0.1
 */
public class SentencesTest {
    /** Test text blob. */
    private TextBlob tb2;
    /** Multi-line test text blob. */
    private TextBlob tb3;

    /**
     * Initialize text blob objects.
     */
    @Before
    public void setup() {
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
     * Tests sentences extractor metric.
     */
    @Test
    public void sentencesTest() {
        Sentences sents = new Sentences();
        Corpus corp = new Corpus("Justin Emanuensis", tb2);
        List<String> result = sents.apply(corp);
        assertEquals(5, sents.apply(corp).size());
        assertEquals("Pack my box with five dozen liquor jugs. ",
                     sents.apply(corp).get(0));
        assertEquals("You don't say!",
                     sents.apply(corp).get(4));
        corp = new Corpus("Yet Another Author", tb3);
        assertEquals(7, sents.apply(corp).size());
        assertEquals("Pack my box with five dozen liquor jugs.\n",
                     sents.apply(corp).get(0));
        assertEquals("You don't say!\n",
                     sents.apply(corp).get(4));
        assertEquals("That's it for now!",
                     sents.apply(corp).get(6));
    }
}
