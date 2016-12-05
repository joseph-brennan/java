import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * The test class NumberOfWordsTest.
 *
 * @author  Joey Brennan
 * @version 1.0
 */
public class NumberOfWordsTest {
    @Test
    public void constructAndApply() {
        Corpus c1 = new Corpus(new String("I. M. N. Auth"),
                               new TextBlob("This is a\ntwo-line text blob it is."));
        NumberOfWords now = new NumberOfWords();
        assertEquals(9L, (long) now.apply(c1));
    }
}
