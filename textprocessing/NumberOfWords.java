import static java.util.Arrays.stream;
import java.util.LongSummaryStatistics;
import java.util.stream.Stream;
/**
 * Text metric that determines the number of words.
 *
 * @author Joey Brennan
 * @version 1.2 template
 */
public class NumberOfWords extends TextMetric<Long> {
    public NumberOfWords() {
        super("Number of Words", Long.class);
    }

    @Override
    public Long apply(final Corpus corp) {
        // Implement using lambda/stream processing.
        return corp.texts().stream()
                           .flatMap(tb -> Stream.of(tb.text().split("\\W+")))
                           .count();
    }
}
