import java.util.stream.Stream;
/**
 * Number of unique words.
 * @author Joey Brennan
 * @version 1.2
 */
public class NumberOfUniqueWords extends TextMetric<Long> {
    public NumberOfUniqueWords() {
        super("Number of Unique Words", Long.class);
    }

    @Override
    public Long apply(final Corpus corp) {
        // Implement using lambda/stream processing.
        return corp.texts().stream()
        				   .flatMap(tb -> Stream.of(tb.text().split("\\W+")))
                           .filter(str -> !str.isEmpty())
                           .distinct()
                           .count();
    }
}
