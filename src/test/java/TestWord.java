import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestWord {

    private List<Sentence> sentenceList = new ArrayList<>();

    private void Initialize_Several_Sentences() {
        sentenceList.add(new Sentence(1, "a bilingual charmer , just like the woman who inspired it"));
        sentenceList.add(new Sentence(0, "Like a less dizzily gorgeous companion to Mr. Wong 's In"));
        sentenceList.add(new Sentence(-1, "As inept as big-screen remakes of The Avengers and The Wild Wild West"));
        sentenceList.add(new Sentence(0, "It 's everything you 'd expect -- but nothing more"));
        sentenceList.add(new Sentence(2, "Best indie of the year, so far"));
    }

    @Test
    public void allWords_Web_Count_1()
    {
        sentenceList.clear();
        sentenceList.add(new Sentence(1, "Web"));

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord = Analyzer.FindInWordSet(setOfWords, "web");
        Assert.assertEquals("Count for same word added several times",1, resultingWord .getCount());
    }

    @Test
    public void allWords_Word_web_Count_2()
    {
        sentenceList.clear();
        sentenceList.add(new Sentence(1, "Web"));
        sentenceList.add(new Sentence(3, "Web"));

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord = Analyzer.FindInWordSet(setOfWords, "web");
        Assert.assertEquals("Count for same word added several times",2, resultingWord .getCount());
    }

    @Test
    public void allWords_Word_web_Count_10()
    {
        sentenceList.clear();
        sentenceList.add(new Sentence(1, "Web first"));
        sentenceList.add(new Sentence(3, "Web second"));
        sentenceList.add(new Sentence(3, "Web third"));
        sentenceList.add(new Sentence(1, "Web fourth"));
        sentenceList.add(new Sentence(4, "Web fifth"));
        sentenceList.add(new Sentence(3, "Web sixth"));
        sentenceList.add(new Sentence(1, "Web seventh"));
        sentenceList.add(new Sentence(1, "Web eighth"));
        sentenceList.add(new Sentence(3, "Web nineth"));
        sentenceList.add(new Sentence(2, "Web tenth"));
        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord = Analyzer.FindInWordSet(setOfWords, "web");
        Assert.assertEquals("Count for same word added several times",10, resultingWord .getCount());
        //Assert.assertEquals(true, expectedWord.equals(resultingWord));
    }

    @Test
    public void allWords_Word_web_Total_4()
    {
        sentenceList.clear();
        sentenceList.add(new Sentence(1, "Web"));
        sentenceList.add(new Sentence(3, "Web"));

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord = Analyzer.FindInWordSet(setOfWords, "web");
        Assert.assertEquals(4, resultingWord .getTotal());
        //Assert.assertEquals(true, expectedWord.equals(resultingWord));
    }



    @Test
    public void allWords_Word_as_Count_Total_4()
    {
        sentenceList.clear();
        sentenceList.add(new Sentence(2, "This was not as much fun as I thought it would be"));

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord_as = Analyzer.FindInWordSet(setOfWords, "as");

        Assert.assertEquals("as word wrong score", 4, resultingWord_as.getTotal());
    }

    @Test
    public void allWords_Word_as_Count_Score_2()
    {
        sentenceList.clear();
        sentenceList.add(new Sentence(2, "This was not as much fun as I thought it would be"));

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord_as = Analyzer.FindInWordSet(setOfWords, "as");

        Assert.assertEquals("as word wrong count", 2, resultingWord_as.getCount());
    }

    @Test
    public void allWords_FullText_Word_it_Count_Total_2()
    {
        Initialize_Several_Sentences();

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord_as = Analyzer.FindInWordSet(setOfWords, "it");

        Assert.assertEquals("it word wrong count", 2, resultingWord_as.getCount());
    }

    @Test
    public void allWords_FullText_Word_it_Count_Score_1()
    {
        Initialize_Several_Sentences();

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord_it = Analyzer.FindInWordSet(setOfWords, "it");

        Assert.assertEquals("it word wrong total score", 1, resultingWord_it.getTotal());
    }

    @Test
    public void allWords_FullText_Word_it_Count_CalculateScore_0()
    {
        Initialize_Several_Sentences();

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord_it = Analyzer.FindInWordSet(setOfWords, "it");

        Assert.assertEquals("it word wrong Calculate score", 0.5, resultingWord_it.calculateScore(), 1);
    }

    @Test
    public void allWords_FullText_Word_the_Count_CalculateScore_1()
    {
        Initialize_Several_Sentences();

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord_it = Analyzer.FindInWordSet(setOfWords, "the");

        Assert.assertEquals("the word wrong Calculate score", 1, resultingWord_it.calculateScore(),1);
    }

    @Test
    public void allWords_FullText_Word_indie_Count_CalculateScore_025()
    {
        Initialize_Several_Sentences();

        Set<Word> setOfWords = Analyzer.allWords(sentenceList);

        Word resultingWord_it = Analyzer.FindInWordSet(setOfWords, "the");

        Assert.assertEquals("the word wrong Calculate score", 0.25, resultingWord_it.calculateScore(),1);
    }
}
