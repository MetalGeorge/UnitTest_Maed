import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSentences {


    @Test
    public void ReturnSentencesFromStringList_2Webdevelopment_ScoresAndTextsOK()
    {
        List<String> resultString = new ArrayList<>();
        resultString.add("2 Web Development");
        Sentence expected = new Sentence(2, "Web Development");
        List<Sentence> resultList = Analyzer.ReturnSentencesFromStringList(resultString);
        Assert.assertEquals("Scores are not the same", expected.getScore(), resultList.get(0).getScore());
        Assert.assertEquals("Texts are not the same", expected.getText(), resultList.get(0).getText());
    }

    @Test
    public void ReturnSentencesFromStringList_WrongFormatNoScore_EmptyList()
    {
        List<String> resultString = new ArrayList<>();
        resultString.add("Web Development");

        List<Sentence> resultList = Analyzer.ReturnSentencesFromStringList(resultString);

        Assert.assertEquals("String doesn't have the proper format", true, resultList.isEmpty());

    }

    @Test
    public void ReturnSentencesFromStringList_WrongFormatNoText_EmptyList()
    {
        List<String> resultString = new ArrayList<>();
        resultString.add("2");

        List<Sentence> resultList = Analyzer.ReturnSentencesFromStringList(resultString);

        Assert.assertEquals("String doesn't have the proper format", true, resultList.isEmpty());

    }

    @Test
    public void ReturnSentencesFromStringList_WrongRangeGreaterThan2InFirst_EmptyList()
    {
        List<String> resultString = new ArrayList<>();
        resultString.add("55 Any given string");
        List<Sentence> resultList = Analyzer.ReturnSentencesFromStringList(resultString);
        Assert.assertEquals("String doesn't have the proper format", true, resultList.isEmpty());
    }

    @Test
    public void ReturnSentencesFromStringList_WrongRangeLesserThan2InFirst_EmptyList()
    {
        List<String> resultString = new ArrayList<>();
        resultString.add("-3 Any given string");
        List<Sentence> resultList = Analyzer.ReturnSentencesFromStringList(resultString);
        Assert.assertEquals("String doesn't have the proper format", true, resultList.isEmpty());
    }
}
