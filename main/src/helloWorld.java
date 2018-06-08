import java.io.PrintStream;
import java.util.List;

public class helloWorld {
    public static void main(String[] args)
    {
        List<Sentence> list = Analyzer.ReadFile("C:\\MaedWeb\\UnitTest\\maed_it_1\\main\\testPhrases.txt");
        for (Sentence sent : list) {
            System.out.println(sent.text);
        }
    }

}
