import java.text.BreakIterator;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
/**
 * Retrieves the sentences of a corpus.
 *
 * @author Dr. Jody Paul
 * @version 1.2.1
 */
public class Sentences extends TextMetric<List<String>> {
    /** A default locale. */
    public static final Locale DEFAULT_LOCALE = Locale.US;

    /** The actual locale for this metric object. */
    private Locale sentenceLocale;

    /**
     * Create sentences metric using default locale.
     */
    public Sentences() {
        this(DEFAULT_LOCALE);
    }

    /**
     * Create sentences metric using specified locale.
     * @param locale the locale for this metric;
     *               if <tt>null</tt> uses default locale
     */
    public Sentences(final Locale locale) {
        super("Sentences", List.class);
        if (locale != null) {
            this.sentenceLocale = locale;
        } else {
            this.sentenceLocale = DEFAULT_LOCALE;
        }
    }

    /**
     * Determines the sentences in the corpus.
     * Result is based on locale specified at object construction.
     * @param corp the corpus to analyze
     * @return the sentences
     */
    @Override
    public List<String> apply(final Corpus corp) {
        List<String> sentenceList = new ArrayList<String>();
        BreakIterator sentit
                = BreakIterator.getSentenceInstance(this.sentenceLocale);
        if (corp != null) {
            for (TextBlob tb : corp.texts()) {
                String text = tb.text();
                sentenceList.addAll(findSentences(text, sentit));
            }
        }
        return sentenceList;
    }

    /**
     * Returns a list of sentences from the parameter.
     * @param sourceText the text to analyze
     * @param sentIt the BreakIterator for sentence detection
     * @return the sentences
     */
    private static List<String> findSentences(final String sourceText,
                                              final BreakIterator sentIt) {
        List<String> sentenceList = new ArrayList<String>();
        sentIt.setText(sourceText);
        int sentenceBegin = sentIt.first();
        int sentenceEnd = sentIt.next();
        while (sentenceEnd != BreakIterator.DONE) {
            sentenceList.add(sourceText.substring(sentenceBegin, sentenceEnd));
            sentenceBegin = sentenceEnd;
            sentenceEnd = sentIt.next();
        }
        return sentenceList;
    }
}
