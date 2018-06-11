import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestCalculateScores {

    @Test
    public void calculateScores_Word_Score1()
    {
        Set<Word> setOfWords =  new HashSet<>();
        String wordToTest = "someWord";
        Word webWord = new Word(wordToTest);
        webWord.increaseTotal(1);

        setOfWords.add(webWord);
        Map<String, Double> result = new HashMap<>();

        result = Analyzer.calculateScores(setOfWords);

        Integer countAppearences = 1;
        Integer sumOfValues = 1;
        Double expectedCalculate = (double)sumOfValues/countAppearences;
        Assert.assertEquals("Wrong Calculate score for 1 appearance and 1 value", expectedCalculate, result.get(wordToTest).doubleValue(), 1);
    }

    @Test
    public void calculateScores_Word_Score4()
    {
        Set<Word> setOfWords =  new HashSet<>();
        String wordToTest = "someWord";
        Word webWord = new Word(wordToTest);
        webWord.increaseTotal(4);
        webWord.increaseTotal(4);
        webWord.increaseTotal(4);
        webWord.increaseTotal(4);

        setOfWords.add(webWord);
        Map<String, Double> result = new HashMap<>();

        result = Analyzer.calculateScores(setOfWords);

        Integer countAppearences = 4;
        Integer sumOfValues = 16;
        Double expectedCalculate = (double)sumOfValues/countAppearences;
        Assert.assertEquals("Wrong Calculate score for 4 appearance and 16 value", expectedCalculate, result.get(wordToTest).doubleValue(), 1);
    }

    @Test
    public void calculateScores_Word_Score7()
    {
        Set<Word> setOfWords =  new HashSet<>();
        String wordToTest = "someWord";
        Word webWord = new Word(wordToTest);
        webWord.increaseTotal(6);
        webWord.increaseTotal(8);


        setOfWords.add(webWord);
        Map<String, Double> result = new HashMap<>();

        result = Analyzer.calculateScores(setOfWords);
        Integer countAppearences = 2;
        Integer sumOfValues = 14;
        Double expectedCalculate = (double)sumOfValues/countAppearences;
        Assert.assertEquals("Wrong Calculate score for 2 appearance and 14 value", expectedCalculate, result.get(wordToTest).doubleValue(), 1);
    }

    @Test
    public void calculateScores_EmpySet_EmptyResult()
    {
        Set<Word> setOfWords =  new HashSet<>();
        Map<String, Double> result = new HashMap<>();
        result = Analyzer.calculateScores(setOfWords);
        boolean isMapEmpty = true;
        Assert.assertEquals("Test emptyy set -> empty map", isMapEmpty , result.isEmpty());
    }
    @Test
    public void calculateScores_NullSet_EmptyResult()
    {
        Map<String, Double> result = new HashMap<>();
        result = Analyzer.calculateScores(null);
        boolean isMapEmpty = true;
        Assert.assertEquals("Test emptyy set -> empty map", isMapEmpty , result.isEmpty());
    }
}
