import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Tests for class FindWords.
 *
 * @author  Dr. Jody Paul
 * @version 1.1
 */
public class FindWordsTest {
    /** Text for input file. */
    private static final String TESTTEXT = "Some text for the file. This has\n"
                                           + "three sentences. Over two lines!";
    /** Tokens associated with test text. */
    private static final String[] TOKENS = {"Some", "text", "for", "the",
                                            "file", "This", "has", "three",
                                            "sentences", "Over", "two",
                                            "lines"};
    /** Path to the temporary file. */
    private static Path tempFilePath = null;
    /**
     * Initialize test file.
     */
    @BeforeClass
    public static void setupTestFile() {
        try {
            tempFilePath = Files.createTempFile(null, ".txt");
            // System.out.format("Using temp file: %s%n", tempFilePath);
        } catch (IOException x) {
            System.err.format("FindWordsTest IOException 1: %s%n", x);
        }
        try {
            Files.write(tempFilePath, TESTTEXT.getBytes());
        } catch (IOException x) {
            System.err.format("FindWordsTest IOException 2: %s%n", x);
        }
        if (tempFilePath == null) {
            fail("Unable to create temp file.");
        }
    }

    /**
     * Delete test file.
     */
    @AfterClass
    public static void teardown() {
        try {
            Files.delete(tempFilePath);
        } catch (IOException x) {
            System.err.format("FindWordsTest teardown IOException: %s%n", x);
        }
    }

    /**
     * Invokes the showWords1 method.
     * @throws java.io.IOException if error using temporary files.
     */
    @Test
    public void showWords1Test() throws java.io.IOException {
        List<String> words = FindWords.showWords1(tempFilePath.toString());
        assertEquals("Incorrect number of words.", TOKENS.length, words.size());
        assertTrue(words.containsAll(Arrays.asList(TOKENS)));
        for (int i = 0; i < TOKENS.length; i++) {
            assertEquals("Words not in same order.", TOKENS[i], words.get(i));
        }
    }

    /**
     * Invokes the showWords2 method.
     * @throws java.io.IOException if error using temporary files.
     */
    @Test
    public void showWords2Test() throws java.io.IOException {
        List<String> words = FindWords.showWords2(tempFilePath.toString());
        assertEquals("Incorrect number of words.", TOKENS.length, words.size());
        assertTrue(words.containsAll(Arrays.asList(TOKENS)));
        for (int i = 0; i < TOKENS.length; i++) {
            assertEquals("Words not in same order.", TOKENS[i], words.get(i));
        }
    }
}
