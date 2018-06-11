import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

public class TestReadFile {
    @Test
    public void ReadFile_Sentences_Empty()
    {
        List<Sentence> list = Analyzer.ReadFile("Non-Existing-File.txt");
        Assert.assertEquals(true, list.isEmpty());
    }
    @Test
    public void ReadFile_Sentences_LoadOne()
    {
        Path currentPath = FileSystems.getDefault().getPath("").toAbsolutePath();
        String fileName = currentPath + "testPhrases.txt";
        List<Sentence> list = Analyzer.ReadFile(fileName);
        Assert.assertEquals(false, list.isEmpty());
    }
}
