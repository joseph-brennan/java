/**
 * Vocabulary richness.
 * @author Dr. Jody Paul
 * @version 1.1
 */
public class VocabularyRichness extends TextMetric<Double> {
    public VocabularyRichness() {
        super("Vocabulary Richness", Double.class);
    }

    @Override
    public Double apply(final Corpus corp) {
        Long numWords = (new NumberOfWords()).apply(corp);
        Long numUniqueWords = (new NumberOfUniqueWords()).apply(corp);
        return (double) numUniqueWords / (double) numWords;
    }
}
