import java.io.IOException;
import java.util.*;
import java.io.File;

import java.util.Scanner;

public class Analyzer {

    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> ReadFile(String filename) {
        List<Sentence> list = new ArrayList<>();
        List<String> listString = new ArrayList<>();
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
        List<Sentence> list = new ArrayList<>();
        for (String possibleSentence : listString) {
            String[] parts = possibleSentence.split(" ");

            try {
                Integer score = Integer.parseInt(parts[0]);
                if (score>=-2 && score <= 2) {
                    String restOfSentence = possibleSentence.replaceFirst(parts[0], "");
                    if (restOfSentence.trim().length()>0) {
                        list.add(new Sentence(score, restOfSentence.trim()));
                    }
                }
            }
            catch (NumberFormatException exception)
            {
                // intentionally left blank if first string is not parseable as number then nothing to do
            }

        }
        return list;
    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {

        Set<Word> returnSet = new HashSet<>();

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
    public static Map<String, Double> calculateScores(Set<Word> setOfWords) {
        Map<String, Double> result = new HashMap<>();
        if (setOfWords == null)
            return result;
        for (Iterator<Word> it = setOfWords.iterator(); it.hasNext(); ) {
            Word word = it.next();
            result.put(word.text, word.calculateScore());
        }
        return result;
    }

}
