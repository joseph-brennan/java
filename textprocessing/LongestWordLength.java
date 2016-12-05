import static java.util.Arrays.stream;
import java.util.LongSummaryStatistics;
/**
 * Length of longest word.
 * @author Dr. Jody Paul
 * @version 1.1
 */
public class LongestWordLength extends TextMetric<Integer> {
    public LongestWordLength() {
        super("Length of Longest Word", Integer.class);
    }

    public Integer apply(final Corpus corp) {
        LongSummaryStatistics lss = corp.texts().stream()
                                        .map(blob -> blob.text())
                                        .flatMap(string -> stream(string.split("\\W+")))
                                        .filter(string -> !string.isEmpty())
                                        .mapToLong(String::length)
                                        .summaryStatistics();
        return (int) lss.getMax();
    }
}
