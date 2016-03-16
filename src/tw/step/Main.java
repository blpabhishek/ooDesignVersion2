package tw.step;

import org.apache.commons.cli.ParseException;
import tw.step.lib.CompositePredicate;
import tw.step.lib.NameFormat;
import tw.step.lib.People;
import tw.step.records.ArgumentParser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        ArgumentParser argumentParser = new ArgumentParser(args);
        argumentParser.setOptions();
        NameFormat nameFormat = argumentParser.getFormat();
        CompositePredicate compositePredicate = argumentParser.getPredicates();
        List<String> files = argumentParser.getFiles();
        for (String file : files) {
            List<String> stringList = readFile(file);
            People people = People.createPeople(stringList);
            People filterPeople = people.filter(compositePredicate);
            String printValue = filterPeople.printLabel(nameFormat,compositePredicate);
            System.out.println(printValue);
        }
    }
    public static List<String> readFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        return lines;
    }
}
