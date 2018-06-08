import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSentences {
    @Test
    public void ReturnSentencesFromStringList_2Webdevelopment_Correct()
    {
        List<String> resultString = new ArrayList();
        resultString.add("2 Web Development");
        Sentence expected = new Sentence(2, "Web Development");
        List<Sentence> resultList = Analyzer.ReturnSentencesFromStringList(resultString);
        Assert.assertEquals("Scores are not the same", expected.getScore(), resultList.get(0).getScore());
        Assert.assertEquals("Texts are not the same", expected.getText(), resultList.get(0).getText());
    }
}
