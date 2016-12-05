import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Demonstrations of parsing a string into lexical tokens.
 * Methods address different input sources and ways of reading
 * from those sources.
 * The source code also demonstrates alternative iteration
 * techniques for processing all elements of a list.
 * @author Dr. Jody Paul
 * @version 1.4
 */
public final class FindWords {
    /**
     * Parse a string into component lexical tokens.
     * Default delimiters are non-word characters.
     * @param instring the string to be parsed
     * @return tokens comprising the parameter
     */
    public static List<String> tokens(final String instring) {
        return Arrays.asList(instring.split("\\W+"));
    }

    /**
     * Driver that prompts for and accepts string from the terminal
     * then splits into token words and displays results to the terminal.
     * @param args ignored
     * @throws IOException if problems with reading input
     */
    public static void main(final String[] args) throws IOException {
        showWords0();
    }

    /**
     * Prompts for and accepts a string from the terminal
     * then splits into token words and displays results to terminal.
     * @throws IOException if problems with reading input
     * @return the tokenized words
     */
    public static List<String> showWords0() throws IOException {
        System.out.print("Please enter a string: ");
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        List<String> words = tokens(line);
        //System.out.println("\"" + line + "\"" + " has "
        //                   + words.size() + " words:");
        /* This version uses a numeric for loop. */
        //for (int i = 0; i < words.size(); i++) {
        //    System.out.println(words.get(i));
        //}
        return words;
    }

    /**
     * Driver that accepts a file name
     * then reads that file line by line,
     * splitting contents into token words,
     * then displays results to the terminal.
     * @param filename the name of the file
     * @throws IOException if problems with reading input
     * @return the tokenized words
     */
    public static List<String> showWords1(final String filename) throws IOException {
        Collection<String> words = new ArrayList<String>();
        for (String linetext : Files.readAllLines(Paths.get(filename))) {
            words.addAll(tokens(linetext));
        }
        //System.out.println("\"" + filename + "\"" + " has "
        //                   + words.size() + " words:");
        /* This version uses an enhanced-for (for-each) loop. */
        //for (String w : words) {
        //    System.out.println(w);
        //}
        return (List<String>) words;
    }

    /**
     * Driver that accepts a file name
     * then reads that file and splits
     * its contents into token words.
     * @param filename the name of the file
     * @throws IOException if problems with reading input
     * @return the tokenized words
     */
    public static List<String> showWords2(final String filename) throws IOException {
        String filetext = new String(Files.readAllBytes(Paths.get(filename)));
        Collection<String> words = tokens(filetext);
        //System.out.println("\"" + filename + "\"" + " has "
        //                   + words.size() + " words:");
        /* This version uses Iterable.forEach with a lambda. */
        //words.forEach(w -> System.out.println(w));
        return (List<String>) words;
    }

    /** Hidden constructor for utility class. */
    private FindWords() { }
}
