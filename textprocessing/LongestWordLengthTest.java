import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Tests for LongestWordLength.
 *
 * @author  Dr. Jody Paul
 * @version 1.0
 */
public class LongestWordLengthTest {
    @Test
    public void constructAndApply() {
        Corpus c1 = new Corpus(new String("I. M. N. Auth"),
                               new TextBlob("This is a\ntwo-line text blob with longest word of length 7."));
        LongestWordLength lwl = new LongestWordLength();
        assertEquals(7, (int) lwl.apply(c1));
    }
}
