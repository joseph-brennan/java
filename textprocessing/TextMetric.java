// TextMetric.java
/**
 * Common aspects of text metrics.
 * @param <T> the return type of the metric
 *
 * @author Dr. Jody Paul
 * @version 1.1
 */
public abstract class TextMetric<T> {
    /** The display name of this metric. */
    private String name;

    /** The return type of this metric. */
    private Class<?> type;

    /**
     * Constructor for defaulted text metrics.
     */
    public TextMetric() {
        this("");
    }

    /**
     * Constructor for unnamed text metrics
     * with a specified return type.
     * @param returnType the type of result
     */
    public TextMetric(final Class<?> returnType) {
        this("", returnType);
    }

    /**
     * Constructor for text metrics with
     * specified name and default return type.
     * @param metricName the display name of this metric
     */
    public TextMetric(final String metricName) {
        this(metricName, Long.class);
    }

    /**
     * Constructor for text metrics with
     * specified name and return type.
     * @param metricName the display name of this metric
     * @param returnType the type of result
     */
    public TextMetric(final String metricName, final Class<?> returnType) {
        this.name = metricName;
        this.type = returnType;
    }

    /**
     * Retrieves the type of values returned by this metric.
     * @return the type returned by this metric
     */
    public Class<?> getType() {
        return this.type;
    }

    /**
     * Applies this metric to specified corpus.
     * @param corp the corpus to be analyzed
     * @return the result of applying this metric to the corpus
     */
    public abstract T apply(final Corpus corp);
}
