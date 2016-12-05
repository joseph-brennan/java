import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
/**
 * Example of tests for AverageNumberOfWordsPerSentence,
 * known to provide inadequate testing.
 *
 * @author  Dr. Jody Paul
 * @version 1.3
 */
public class AverageNumberOfWordsPerSentenceTest {
    /** Test text blob 0. */
    private TextBlob ttb0;
    /** Test text blob 1. */
    private TextBlob ttb1;

    /**
     * Initialize test objects.
     */
    @Before
    public void setup() {
        ttb0 = new TextBlob("Test Blob Zero",
                           "Pack my box with five dozen liquor jugs. "
                           + "The quick brown fox jumps over the lazy dog. "
                           + "She sells sea shells by the sea shore. "
                           + "How now brown cow? You don't say!");
        ttb1 = new TextBlob("Test Blob One",
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

    /** Definition of "close-enough" for double comparison. */
    private static final double EPSILON = 0.00001d;

    /**
     * Tests the average number of words per sentence metric
     * using non-empty corpora.
     */
    @Test
    public void averageNumWordsPerSentenceTest() {
        AverageNumberOfWordsPerSentence anowps
                = new AverageNumberOfWordsPerSentence();
        Corpus corp = new Corpus("Justin Emanuensis", ttb0);
        assertEquals(6.6d, anowps.apply(corp), EPSILON);
        corp = new Corpus("Yet Another Author", ttb1);
        assertEquals(8.142857d, anowps.apply(corp), EPSILON);
    }

    /**
     * Tests the average number of words per sentence metric
     * using single word corpus.
     */
    @Test
    public void averageNumWordsPerSentenceOneWordTest() {
        AverageNumberOfWordsPerSentence anowps
                = new AverageNumberOfWordsPerSentence();
        assertEquals(1.0d,
                     anowps.apply(new Corpus("One Word",
                                             new TextBlob("oneword"))),
                     EPSILON);
        assertEquals(1.0d,
                     anowps.apply(new Corpus("One Word With Period",
                                             new TextBlob("oneword."))),
                     EPSILON);
        assertEquals(1.0d,
                     anowps.apply(new Corpus("One Word With Ellipsis",
                                             new TextBlob("oneword..."))),
                     EPSILON);
    }

    /**
     * Tests the average number of words per sentence metric
     * using empty corpus.
     */
    @Test
    public void averageNumWordsPerSentenceEmptyTest() {
        AverageNumberOfWordsPerSentence anowps
                = new AverageNumberOfWordsPerSentence();
        assertEquals("Empty corpus should have 0.0d words per sentence",
                     0.0d, anowps.apply(new Corpus()), EPSILON);
    }

    /**
     * Tests the average number of words per sentence metric
     * using null parameter.
     */
    @Test
    public void averageNumWordsPerSentenceNullTest() {
        AverageNumberOfWordsPerSentence anowps
                = new AverageNumberOfWordsPerSentence();
        assertEquals("null parameter should have 0.0d words per sentence",
                     0.0d, anowps.apply(null), EPSILON);
    }
}
