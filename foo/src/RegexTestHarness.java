/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 * Derivative by Dr. Jody Paul, November 2013.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Test harness for interactive exploration of regular expressions.
 * @author Sun Microsystems, Oracle
 * @author Dr. Jody Paul
 * @version 15 November 2013
 */
public class RegexTestHarness {
    /** Console for I/O. null if no console. */
    private static Console console = System.console();

    /**
     * Driver for interactive regex exploration.
     * @param args ignored
     */
    public static void main(String[] args){
        Console console = System.console();
        while (true) {
            String regexp = requestText("Enter your regular expression: ");
            if (regexp == null) System.exit(42);
            String input = requestText("Enter string to search: ");
            if (input == null) input = "";
            Pattern pattern =
                Pattern.compile(regexp);
            Matcher matcher =
                pattern.matcher(input);
            boolean found = false;
            while (matcher.find()) {
                presentMessage(
                    "regex: " + regexp + "\n"
                    + "input: " + input + "\n"
                    + "Text \""
                    + matcher.group()
                    + "\" found starting at index "
                    + matcher.start()
                    + " and ending at index "
                    + matcher.end()
                    + ".");
                found = true;
            }
            if (!found) {
                presentMessage("No match found.");
            }
        }
    }

    /**
     * Prompt user to enter a string and return what is entered.
     * @param prompt the prompt text
     * @return string entered by the user
     */
    public static String requestText(final String prompt) {
        String response;
        if (console == null) {
            response =
            javax.swing.JOptionPane.showInputDialog(
                null,
                prompt,
                "Please Enter Text",
                javax.swing.JOptionPane.PLAIN_MESSAGE);
            return response;
        }
        return console.readLine("%n" + prompt);
    }

    /**
     * Present a simple message to user.
     * @param message the message text
     */
    public static void presentMessage(final String message) {
        if (console == null) {
            javax.swing.JOptionPane.showMessageDialog(
                null,
                message,
                "Regex Test Harness",
                javax.swing.JOptionPane.PLAIN_MESSAGE);
        } else {
            console.format("%n%s%n", message);
        }
    }
}