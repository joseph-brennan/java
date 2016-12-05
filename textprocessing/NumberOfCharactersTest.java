import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * The test class NumberOfCharactersTest.
 *
 * @author  Dr. Jody Paul
 * @version 1.0
 */
public class NumberOfCharactersTest {
    @Test
    public void constructAndApply() {
        Corpus c1 = new Corpus(new String("I. M. N. Auth"),
                               new TextBlob("This is a\ntwo-line text blob."));
        NumberOfCharacters noc = new NumberOfCharacters();
        assertEquals(29L, (long) noc.apply(c1));
    }
}
