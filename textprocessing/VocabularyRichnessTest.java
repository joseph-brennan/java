import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Tests for VocabularyRichness.
 *
 * @author  Dr. Jody Paul
 * @version 1.0
 */
public class VocabularyRichnessTest {
    @Test
    public void constructAndApply() {
        Corpus c1 = new Corpus(new String("I. M. N. Auth"),
                               new TextBlob("This is a\ntwo-line text blob it is."));
        VocabularyRichness vr = new VocabularyRichness();
        assertEquals(0.888889d, (double) vr.apply(c1), 0.00001d);
    }
}
