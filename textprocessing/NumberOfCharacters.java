// NumberOfCharacters.java
/**
 * Counts the number of characters.
 *
 * @author Dr. Jody Paul
 * @version 1.1
 */
public class NumberOfCharacters extends TextMetric<Long> {
    public NumberOfCharacters() {
        super("Number of Characters", Long.class);
    }

    /**
     * Determine the number of characters in the corpus.
     * @param corp the corpus to analyze
     * @return the number of characters
     */
    public Long apply(final Corpus corp) {
        long numberOfCharacters = 0L;
        for (TextBlob tb : corp.texts()) {
            numberOfCharacters += tb.numberOfCharacters();
        }
        return numberOfCharacters;
    }
}
