import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
/**
 * Combined tests of the text-processing classes.
 *
 * @author  Dr. Jody Paul
 * @version 1.4
 */
public class DriverTest {
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
                           "Now is the time for all good folks "
                           + "to come to the aid of their party.");
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
     * Invokes constructors.
     */
    @Test
    public void constructionTest() {
        Corpus corp0 = new Corpus(new String());
        Corpus corp1 = new Corpus(new String("Ima Writer"), tb1);
        Corpus corp2 = new Corpus(new String("Justin Emanuensis"), tb2);
    }

    /**
     * Checks TextMetrics that use constructors with defaulted parameters.
     */
    @Test
    public void textMetricTest() {
        class TMTypeOnly extends TextMetric<Boolean> {
            TMTypeOnly() {
                super(Boolean.class);
            }
            public Boolean apply(final Corpus c) {
                return true;
            }
        }
        class TMNameOnly extends TextMetric<Long> {
            TMNameOnly() {
                super("Name Only");
            }
            public Long apply(final Corpus c) {
                return 42L;
            }
        }
        class TMDefaultL extends TextMetric<Long> {
            TMDefaultL() {
                super();
            }
            public Long apply(final Corpus c) {
                return 84L;
            }
        }
        class TMDefaultB extends TextMetric<Boolean> {
            TMDefaultB() {
                super();
            }
            public Boolean apply(final Corpus c) {
                return true;
            }
        }
        Corpus emptyCorpus = new Corpus(new String());

        assertEquals(Boolean.class, (new TMTypeOnly()).getType());
        TextMetric<Boolean> tmto = new TMTypeOnly();
        assertTrue(tmto.apply(emptyCorpus));

        assertEquals(Long.class, (new TMNameOnly()).getType());
        TextMetric<Long> tmno = new TMNameOnly();
        assertEquals(42L, (long) tmno.apply(emptyCorpus));

        assertEquals(Long.class, (new TMDefaultL()).getType());
        TextMetric<Long> tmdL = new TMDefaultL();
        assertEquals(84L, (long) tmdL.apply(emptyCorpus));

        assertEquals(Long.class, (new TMDefaultB()).getType()); // Type erasure!
        TextMetric<Boolean> tmdB = new TMDefaultB();
        assertTrue(tmdB.apply(emptyCorpus));
    }

    /**
     * Tests character-level metrics.
     */
    @Test
    public void charactersTest() {
        TextMetric<Long> numChars = new NumberOfCharacters();

        Corpus corp = new Corpus("Ima Writer", tb1);
        assertEquals(69L, (long) numChars.apply(corp));
        Collection<TextBlob> blobs = corp.texts();
        assertEquals(1, blobs.size());
        TextBlob tb = blobs.iterator().next();
        assertNotNull(tb);
        assertEquals(69, tb.numberOfCharacters());
        String string1 = tb.text();
        assertNotNull(string1);
        assertEquals(69, string1.length());

        corp = new Corpus("Justin Emanuensis", tb2);
        assertEquals(158L, (long) numChars.apply(corp));
        blobs = corp.texts();
        assertEquals(1, blobs.size());
        tb = blobs.iterator().next();
        assertNotNull(tb);
        assertEquals(158, tb.numberOfCharacters());
        string1 = tb.text();
        assertNotNull(string1);
        assertEquals(158, string1.length());
    }

    /**
     * Tests word-level metrics.
     */
    @Test
    public void wordsTest() {
        TextMetric<Long> numWords = new NumberOfWords();
        TextMetric<Integer> avgWordLen = new AverageWordLength();
        TextMetric<Double> vocabRich = new VocabularyRichness();

        Corpus corp = new Corpus("Ima Writer", tb1);
        assertEquals(16L, (long) numWords.apply(corp));
        assertEquals(3, (int) avgWordLen.apply(corp));
        assertEquals(0.875d, (double) vocabRich.apply(corp), 0.00001d);

        corp = new Corpus("Justin Emanuensis", tb2);
        assertEquals(33L, (long) numWords.apply(corp));
        assertEquals(3, (int) avgWordLen.apply(corp));
        assertEquals(0.90909d, (double) vocabRich.apply(corp), 0.00001d);
    }

    /**
     * Tests corpora with multiple TextBlobs, character and word metrics.
     */
    @Test
    public void multiBlobTest() {
        TextMetric<Long> numChars = new NumberOfCharacters();
        TextMetric<Long> numWords = new NumberOfWords();
        TextMetric<Integer> avgWordLen = new AverageWordLength();
        TextMetric<Double> vocabRich = new VocabularyRichness();

        Corpus corp = new Corpus("Ann Otterau Thore", tb1);
        corp.addText(tb2);
        assertEquals(227L, (long) numChars.apply(corp));
        Collection<TextBlob> blobs = corp.texts();
        assertEquals(2, blobs.size());
        Iterator<TextBlob> tbit = blobs.iterator();
        TextBlob tb = tbit.next();
        assertNotNull(tb);
        assertEquals(69, tb.numberOfCharacters());
        tb = tbit.next();
        assertNotNull(tb);
        assertEquals(158, tb.numberOfCharacters());
        assertEquals(49L, (long) numWords.apply(corp));
        assertEquals(3, (int) avgWordLen.apply(corp));
        assertEquals(0.87755d, (double) vocabRich.apply(corp), 0.00001d);

        corp.addText(tb3);
        assertEquals(520L, (long) numChars.apply(corp));
        assertEquals(106L, (long) numWords.apply(corp));
        assertEquals(3, (int) avgWordLen.apply(corp));
        assertEquals(0.56604d, (double) vocabRich.apply(corp), 0.00001d);
        assertEquals(158, tb.numberOfCharacters());
    }
}
