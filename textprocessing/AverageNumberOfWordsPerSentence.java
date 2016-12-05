import java.util.IntSummaryStatistics;
import java.util.List;
/**
 * Average number of words per sentence.
 * @author Joey Brennan
 * @version 1.3
 */
public class AverageNumberOfWordsPerSentence extends TextMetric<Double> {
  public AverageNumberOfWordsPerSentence() {
    super("Average Number of Words Per Sentence", Double.class);
  }

  @Override
  public Double apply(final Corpus corp) {
      // Implement using lambda/stream processing.
      // Must not use a division or modulo operators.
      // Must not invoke NumberOfWords TextMetric.
	  Sentences obj = new Sentences();
	  List<String> sentenceList = obj.apply(corp);
	  
		  return sentenceList.stream()
	  				.mapToDouble(sentence -> sentence.split("\\W+").length)
	  				.average()
	  				.orElse(0);

      //return Double.MIN_VALUE;
  }
}
