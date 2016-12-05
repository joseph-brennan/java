//TextBlobTest.java
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
/**
 * The test class TextBlobTest.
 *
 * @author  Dr. Jody Paul
 * @version 1.2
 */
public class TextBlobTest {
    /**
     * Construct blob using no parameters;
     * check number of characters, text and ID.
     */
    @Test
    public void noParamConstructorTest() {
        TextBlob tb0 = new TextBlob();
        assertEquals(0, tb0.numberOfCharacters());
        assertEquals("", tb0.text());
        assertEquals("", tb0.id());
    }

    /**
     * Construct blob using single-parameter initial text;
     * check number of characters, text and ID.
     */
    @Test
    public void oneParamConstructorTest() {
        TextBlob tb1 = new TextBlob("This is the initial text for this blob.");
        assertEquals(39, tb1.numberOfCharacters());
        assertEquals("This is the initial text for this blob.", tb1.text());
        assertEquals("", tb1.id());
        TextBlob tb1a = new TextBlob("Another blob.");
        assertEquals(39, tb1.numberOfCharacters());
        assertEquals("This is the initial text for this blob.", tb1.text());
        assertEquals("", tb1.id());
    }

    /**
     * Construct blob using two parameters, the ID and initial text;
     * check number of characters, text and ID.
     */
    @Test
    public void twoParamConstructorTest() {
        TextBlob tb2 = new TextBlob("Two Parm",
                                    "Here's the initial text for this blob.");
        assertEquals(38, tb2.numberOfCharacters());
        assertEquals("Here's the initial text for this blob.", tb2.text());
        assertEquals("Two Parm", tb2.id());
        TextBlob tb2a = new TextBlob("Another Double",
                                     "Text for another.");
        assertEquals(38, tb2.numberOfCharacters());
        assertEquals("Here's the initial text for this blob.", tb2.text());
        assertEquals("Two Parm", tb2.id());
    }

    /**
     * Construct blob using three parameters,
     * the ID, initial text and file name;
     * check number of characters, text and ID.
     * (Creates a temporary file.)
     */
    @Test
    public void threeParamConstructorTest() {
        String paramText = "Initial text from parameter.";
        String fileText = "Additional text from file.";
        Path tempFile = null;
        try {
            tempFile = Files.createTempFile(null, ".txt");
            // System.out.format("Using temp file: %s%n", tempFile);
        } catch (IOException x) {
            System.err.format("Test IOException 1: %s%n", x);
        }
        try {
            Files.write(tempFile, fileText.getBytes());
        } catch (IOException x) {
            System.err.format("Test IOException 2: %s%n", x);
        }
        TextBlob tb3 = new TextBlob("Three Parm",
                                    paramText,
                                    tempFile.toString());
        assertEquals(paramText.length() + fileText.length(),
                     tb3.numberOfCharacters());
        assertEquals(paramText + fileText, tb3.text());
        assertEquals("Three Parm", tb3.id());
        TextBlob tb3a = new TextBlob("Three Parmagiana",
                                     "Test string.",
                                     tempFile.toString());
        assertEquals(paramText.length() + fileText.length(),
                     tb3.numberOfCharacters());
        assertEquals(paramText + fileText, tb3.text());
        assertEquals("Three Parm", tb3.id());
    }

    /**
     * Exercises the append method;
     * checks number of characters, text and ID.
     */
    @Test
    public void appendTest() {
        TextBlob tb = new TextBlob("Test Blob",
                                   "The original text\nin two lines.");
        assertEquals(31, tb.numberOfCharacters());
        assertEquals("The original text\nin two lines.", tb.text());
        tb.append("");
        assertEquals(31, tb.numberOfCharacters());
        assertEquals("The original text\nin two lines.", tb.text());
        tb.append("Added text.\nThree lines\nlong.");
        assertEquals(60, tb.numberOfCharacters());
        assertEquals("The original text\nin two lines."
                         + "Added text.\nThree lines\nlong.",
                     tb.text());
        assertEquals("Test Blob", tb.id());
        TextBlob tba = new TextBlob("Extra blob",
                                    "Extra text.");
        assertEquals(60, tb.numberOfCharacters());
        assertEquals("The original text\nin two lines."
                         + "Added text.\nThree lines\nlong.",
                     tb.text());
        assertEquals("Test Blob", tb.id());
    }

    /**
     * Exercises the two-parameter append method
     * using text and file name;
     * checks number of characters, text and ID.
     * (Creates a temporary file.)
     */
    @Test
    public void twoParameterAppendText() {
        String initText = "Initial text from constructor.";
        String paramText = "Appended text from parameter.";
        String fileText = "Additional appended text from file.";
        Path tempFile = null;
        try {
            tempFile = Files.createTempFile(null, ".txt");
            // System.out.format("Using temp file: %s%n", tempFile);
        } catch (IOException x) {
            System.err.format("Test IOException 1: %s%n", x);
        }
        try {
            Files.write(tempFile, fileText.getBytes());
        } catch (IOException x) {
            System.err.format("Test IOException 2: %s%n", x);
        }
        TextBlob tb4 = new TextBlob("Two-Param Append Test",
                                    initText);
        tb4.append(paramText, tempFile.toString());
        assertEquals(initText.length() + paramText.length() + fileText.length(),
                     tb4.numberOfCharacters());
        assertEquals(initText + paramText + fileText, tb4.text());
        assertEquals("Two-Param Append Test", tb4.id());
        TextBlob tb4a = new TextBlob("Two-Parmagiani",
                                     initText);
        assertEquals(initText.length() + paramText.length() + fileText.length(),
                     tb4.numberOfCharacters());
        assertEquals(initText + paramText + fileText, tb4.text());
        assertEquals("Two-Param Append Test", tb4.id());
    }
}
