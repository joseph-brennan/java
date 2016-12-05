import static java.util.Arrays.stream;
import java.util.LongSummaryStatistics;
/**
 * Average word length.
 * @author Dr. Jody Paul
 * @version 1.1
 */
public class AverageWordLength extends TextMetric<Integer> {
    public AverageWordLength() {
        super("Average Word Length", Integer.class);
    }

    @Override
    public Integer apply(final Corpus corp) {
        LongSummaryStatistics lss = corp.texts().stream()
                                        .map(blob -> blob.text())
                                        .flatMap(string -> stream(string.split("\\W+")))
                                        .filter(string -> !string.isEmpty())
                                        .mapToLong(String::length)
                                        .summaryStatistics();
        return (int) lss.getAverage();
    }
}
