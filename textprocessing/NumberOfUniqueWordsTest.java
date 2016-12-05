import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Tests for NumberOfUniqueWords.
 *
 * @author  Dr. Jody Paul
 * @version 1.0
 */
public class NumberOfUniqueWordsTest {
    @Test
    public void constructAndApply() {
        Corpus c1 = new Corpus(new String("I. M. N. Auth"),
                               new TextBlob("This is a\ntwo-line text blob it is."));
        NumberOfUniqueWords nouw = new NumberOfUniqueWords();
        assertEquals(8L, (long) nouw.apply(c1));
    }
}
