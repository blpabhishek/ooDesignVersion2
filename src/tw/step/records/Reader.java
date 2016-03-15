package tw.step.records;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Reader {
    public static List<String> readFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> strings = Files.readAllLines(path, Charset.defaultCharset());
        return strings;
    }

}