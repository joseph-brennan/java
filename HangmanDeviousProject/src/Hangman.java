import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Devious Hangman implements the HangmanManager.
 * Methods provide access to the current set of guesses,
 * number of wrong guesses remaining, and the current pattern
 * to be displayed to the user.
 * The <CODE>record</CODE> method updates state by recording a new guess
 * and updating the other values appropriately.
 * <P>
 * Implementing classes must include a constructor of the following form:
 * <PRE>
 * public HangmanManager(final List<String> dictionary,
 *                       final int length,
 *                       final int max)
 * </PRE>
 * This constructs a HangmanManager by first determining the initial
 * set of words with the specified length from the dictionary
 * then selecting the goal.
 * <UL>
 * <LI>The dictionary parameter is a list of candidate goal words.</LI>
 * <LI>The length parameter is the length of acceptable candidate goal words.</LI>
 * <LI>The max parameter is the maximum number of wrong guesses permitted.</LI>
 * <LI>The constructor throws and IllegalArgumentException if length < 1.
 * or if max < 0.</LI>
 * </UL>
 * </P>
 *
 * @author Joey Brennan
 * @version 1.1
 */
public class Hangman implements HangmanManager {
    /** the length of the chosen word. */
    private int wordLength;

    /** The dictionary of words of the given length. */
    private Set<String> givenDictionary;

    /** number of guesses that are left. */
    private int numLeft;

    /** set of guessed characters. */
    private TreeSet<Character> guessedChar;

    /** current game printout. */
    private String gamePattern;

    /**
     * This constructor is passed a dictionary of words,
     * a target word length, and the maximum number of wrong guesses the player
     * is allowed to make. It should use these values to initialize the state of
     * the game. An internal set of words should initially be all words from the
     * dictionary that are of the given length.
     * The constructor should throw an IllegalArgumentException
     * if length is less than 1 or if max is less than 0.
     *
     * @param dictionary of words
     * @param length target word length
     * @param max of incorrect guesses
     * @throws IllegalArgumentException if length is less than 1
     * or max is less than 0
     */
    Hangman(final List<String> dictionary, final int length, final int max)
            throws IllegalArgumentException {
        if (length < 1) {
            throw new IllegalArgumentException("length passed in < 1");

        } else {
            this.wordLength = length;
        }
        if (max < 0) {
            throw new IllegalArgumentException("Max is less than 0");

        } else {
            this.numLeft = max;
        }

        this.givenDictionary = dictionary.stream()
                .filter(string -> string.length() == wordLength)
                .collect(Collectors.toSet());

        this.guessedChar = new TreeSet<Character>();

        this.gamePattern = contructPattern(givenDictionary.iterator().next());
    }

    /**
     * Accesses the set of candidate goal words.
     * @return the set of candidate goal words
     */
    public Set<String> words() {
        Set<String> temp;

        temp = this.givenDictionary;

        return temp;
    }

    /**
     * Accesses the number of allowable wrong guesses.
     * @return the number of wrong guesses the user has left
     */
    public int guessesLeft() {
        return numLeft;
    }

    /**
     * Accesses the set of letters already guessed by the user.
     * @return the current set of letters guessed by the user
     */
    public SortedSet<Character> guesses() {
        SortedSet<Character> temp;

        temp = this.guessedChar;

        return temp;
    }

    /**
     * Return the hangman-style display pattern of letters and dashes
     * appropriate to the current state based on the letters already
     * guessed and the goal.
     * @throws IllegalStateException if there is no goal word
     * @return the hangman-style pattern to be displayed to the user
     */
    public String pattern() throws IllegalStateException {
        if (givenDictionary.iterator().next().isEmpty()) {
            throw new IllegalStateException("There is no goal word");
        }

        return gamePattern;
    }

    /**
     * Record state changes based on new letter guess.
     * @throws IllegalStateException if no guesses left or no goal word
     * @throws IllegalArgumentException if letter is already guessed
     * @param guess the letter being guessed
     *   [Precondition: must be lower-case letter]
     *   [Precondition: must not be among letters already guessed]
     * @return the number of occurrences of the guessed letter in the goal
     */
    public int record(final char guess)
            throws IllegalArgumentException, IllegalStateException {

        int numOccur = 0;

        if (givenDictionary.isEmpty()) {
            throw new IllegalArgumentException("List of choices is empty");
        }

        if (givenDictionary.iterator().next().isEmpty()) {
            throw new IllegalStateException("There is no word");
        }

        if (guessedChar.contains(guess)) {
            throw new IllegalArgumentException(
                    "This character already guessed");
        }

        if (numLeft < 1) {
            throw new IllegalStateException("No more guesses left");
        }

        guessedChar.add(guess);

        givenDictionary = deviousDictionary(givenDictionary, guess);
//        System.out.println("\n" + givenDictionary.toString() + "\n");

        this.gamePattern = contructPattern(givenDictionary.iterator().next());

        for (int i = 0; i < givenDictionary.iterator().next().length(); i++) {

            if (givenDictionary.iterator().next().charAt(i) == guess) {
                numOccur++;
            }
        }

        if (numOccur == 0) {
            numLeft--;
        }
        return numOccur;
    }

    /**
     * updates the pattern of the correct guesses.
     *
     * @param testWord the current word being used
     * @return the current pattern
     */
    private String contructPattern(final String testWord) {

        return  testWord.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> guessedChar.contains(ch) ? ch : "-")
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    /**
     * Method that cheats using the largest possible
     * dictionary.
     *
     * @param dictionary the current dictionary
     * @param guess the current letter guessed
     * @return the largest dictionary
     */
    private Set<String> deviousDictionary(
            final Set<String> dictionary, final char guess) {

        Map<String, List<String>> dictionaryPattern = 
                new HashMap<String, List<String>>();

        for (String word : dictionary) {

            String pattern = contructPattern(word);

            if (dictionaryPattern.containsKey(pattern)) {

                dictionaryPattern.get(pattern).add(word);
            } else {
                dictionaryPattern.put(pattern, new ArrayList<String>());

                dictionaryPattern.get(pattern).add(word);
            }
        }
        int max = 0;
        List<String> maxList = new ArrayList<String>();

        for (List<String> list : dictionaryPattern.values()) {
            if (dictionaryPattern.values().size() == 2
                    && list.size() > max && list.contains(guess)) {
                break;

            } else if (list.size() > max && !(list.contains(guess)))  {

                max = list.size();

                maxList = list;
            } else if (list.size() > max) {
                max = list.size();

                maxList = list;
            }
                
        }
        return new TreeSet<String>(maxList);
        
    }
}
