import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analyzer {

    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> ReadFile(String filename) {
        List<Sentence> list = new ArrayList();
        List<String> listString = new ArrayList();
        try (Scanner input = new Scanner(new File (filename))) {
            while (input.hasNext()) {
                listString.add(input.nextLine());
            }
        }
        catch (IOException e) {
            return list;
        }

        list = ReturnSentencesFromStringList(listString);
        return list;
    }

    public static List<Sentence> ReturnSentencesFromStringList(List<String> listString)
    {
        List<Sentence> list = new ArrayList();
        for (String possibleSentence : listString) {
            String[] parts = possibleSentence.split(" ");
            // TODO validate input strings
            int score = Integer.parseInt(parts[0]);
            String restOfSentence = possibleSentence.replaceFirst(parts[0], "");
            list.add(new Sentence(score, restOfSentence.trim()));
        }
        return list;
    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {

        Set<Word> returnSet = new HashSet<>();
        //List<Word> returnList = new ArrayList<>();

        for (Sentence sentence : sentences) {

            String[] arrayOfWords = sentence.text.split(" ");

            for ( String ss : arrayOfWords) {
                String possibleTextToAdd = ss.toLowerCase();

                Word foundWord = FindInWordSet(returnSet, possibleTextToAdd);
                if (foundWord == null) {
                    Word word = new Word(possibleTextToAdd);
                    word.increaseTotal(sentence.score);
                    returnSet.add(word);
                } else {
                    foundWord.increaseTotal(sentence.score);
                }
            }
        }
        return returnSet;

    }

    public static Word FindInWordSet(Set<Word> setOfWords, String textForWord)
    {
        Word wordToFind = new Word(textForWord);
        for (Iterator<Word> it = setOfWords.iterator(); it.hasNext(); ) {
            Word f = it.next();
            if (f.equals(wordToFind))
                return f;
        }
        return null;
    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {

        return null;

    }

}
