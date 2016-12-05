// TextBlob.java
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Contains a blob of text and provides
 * access to attributes of the text.
 * Note that a single blob contains no
 * more than {@link Integer#MAX_VALUE}
 * characters.
 *
 * @author Dr. Jody Paul
 * @version 1.1
 */
public class TextBlob {
    /** Indicates absence of text. */
    private static final String NO_TEXT = "";
    /** Indicates absence of ID. */
    private static final String NO_ID = "";

    /** The actual text stored in this blob. */
    private String blobtext;

    /** Optional identifier for this blob. */
    private String blobID;

    /**
     * Creates a blob with no text.
     */
    public TextBlob() {
        this(NO_ID, NO_TEXT);
    }

    /**
     * Creates a blob where the parameter
     * specifies its text.
     * @param text the text for this blob
     */
    public TextBlob(final String text) {
        this(NO_ID, text);
    }

    /**
     * Creates a blob with specified ID
     * and text.
     * @param id the ID for this blob
     * @param text the text for this blob
     */
    public TextBlob(final String id, final String text) {
        this.blobID = id;
        this.blobtext = text;
    }

    /**
     * Creates a blob with specified ID
     * and text provided in a parameter
     * (possibly null) and loaded from
     * a specified filename (also possibly
     * null). If both text and filename are
     * provided, the text loaded from the
     * file is appended to the text provided
     * in the parameter.
     * @param id the ID for this blob
     * @param text the text for this blob;
     *             null or empty if no text
     * @param filename the name of a file from
     *             which to load text for this
     *             blob; null or empty if no
     *             file to be loaded
     */
    public TextBlob(final String id,
                    final String text,
                    final String filename) {
        this.blobID = id;
        if (text == null) {
            this.blobtext = "";
        } else {
            this.blobtext = text;
        }
        this.blobtext += loadTextFromFile(filename);
    }

    /**
     * Retrieves text from a specified file.
     * If the file name is null or does not
     * correspond to a valid file, returns
     * an empty string.
     * @param filename the name of the file
     * @return the text contained in the named
     *         file or the empty string
     */
    private String loadTextFromFile(final String filename) {
        String text = "";
        if (filename == null || filename.isEmpty()) {
            text = "";
        } else {
            try {
                text += new String(Files.readAllBytes(Paths.get(filename)));
            } catch (Exception e) {
                System.err.println("loadTextFromFile: " + e);
                text += "";
            }
        }
        return text;
    }

    /**
     * Appends text to this blob.
     * @param text the text be appended
     */
    public void append(final String text) {
        this.blobtext += text;
    }

    /**
     * Appends text to this blob.
     * The text is provided in a parameter
     * (possibly null) and loaded from
     * a specified filename (also possibly
     * null). If both text and filename are
     * provided, the given in the parameter
     * is appended first, followed by the
     * text loaded from the file.
     * @param text the text be appended;
     *             null or empty if no text
     * @param filename the name of a file from
     *             which to load text to append
     *             to this blob; null or empty
     *             if no file from which to load
     */
    public void append(final String text,
                       final String filename) {
        if (text != null) {
            this.blobtext += text;
        }
        this.blobtext += loadTextFromFile(filename);
    }

    /**
     * Retrieves the text in this blob.
     * @return the text
     */
    public String text() {
        return this.blobtext;
    }

    /**
     * Retrieves the ID of this blob.
     * @return the ID
     */
    public String id() {
        return this.blobID;
    }

    /**
     * Retrieves the number of characters in this blob.
     * @return the number of characters
     */
    public long numberOfCharacters() {
        return this.blobtext.length();
    }
}
