import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Tests for AverageWordLength.
 *
 * @author  Dr. Jody Paul
 * @version 1.0
 */
public class AverageWordLengthTest {
    @Test
    public void constructAndApply() {
        Corpus c1 = new Corpus(new String("I. M. N. Auth"),
                               new TextBlob("This is a\ntwo-line text blob."));
        AverageWordLength awl = new AverageWordLength();
        assertEquals(3, (int) awl.apply(c1));
    }
}
