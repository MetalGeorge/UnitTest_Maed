import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestReadFile {
    @Test
    public void ReadFile_Sentences_Empty()
    {
        List<Sentence> list = Analyzer.ReadFile("C:\\MaedWeb\\UnitTest\\maed_it_1\\main\\testPhrasesNoExist.txt");
        Assert.assertEquals(true, list.isEmpty());
    }
    @Test
    public void ReadFile_Sentences_LoadOne()
    {
        List<Sentence> list = Analyzer.ReadFile("C:\\MaedWeb\\UnitTest\\maed_it_1\\main\\testPhrases.txt");
        Assert.assertEquals(false, list.isEmpty());
    }
}
