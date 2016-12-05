import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
/**
 * Corpus of text.
 *
 * @author Dr. Jody Paul
 * @version 1.2
 */
public class Corpus {
    /** The author associated with this corpus. */
    private String corpusAuthor;

    /** List of text blobs comprising this corpus. */
    private final List<TextBlob> corp = new ArrayList<TextBlob>();

    /**
     * Creates an empty corpus with
     * unknown author.
     */
    public Corpus() {
        this("");
    }

    /**
     * Creates an empty corpus for
     * specified author.
     * @param author the author
     */
    public Corpus(final String author) {
        this(author, null);
    }

    /**
     * Creates a corpus for
     * specified author with initial text.
     * @param author the author
     * @param text the initial text (ignored if <code>null</code>)
     */
    public Corpus(final String author, final TextBlob text) {
        this.corpusAuthor = author;
        if (text != null) {
            this.corp.add(text);
        }
    }

    /**
     * Accesses text blobs comprising this corpus.
     * @return the collection of text blobs
     */
    public Collection<TextBlob> texts() {
        return this.corp;
    }

    /**
     * Adds a text blob to this corpus.
     * @param text the text blob to be added
     */
    public void addText(final TextBlob text) {
        this.corp.add(text);
    }

}
