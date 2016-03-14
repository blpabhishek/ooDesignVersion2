package tw.step;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import tw.step.lib.*;
import tw.step.records.ArgumentParser;
import tw.step.records.Reader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        ArgumentParser argumentParser = new ArgumentParser(args);
        argumentParser.setOptions();
        CommandLine commandLine = argumentParser.parse();
        List<String> files = commandLine.getArgList();
        for (String file : files) {
            List<String> stringList = Reader.readFile(file);
            People people = People.createPeople(stringList);
            NameFormat nameFormat = new FirstLastNameFormat();
            CompositePredicate compositePredicate= new CompositePredicate();
            if(commandLine.hasOption("f"))
                nameFormat = new FirstLastNameFormat();
            if(commandLine.hasOption("l"))
                nameFormat = new LastFirstNameFormat();
            if(commandLine.hasOption("a"))
                compositePredicate.add( new AgePredicate(Integer.parseInt(commandLine.getOptionValue("a"))));
            if(commandLine.hasOption("c"))
                compositePredicate.add(new CountryPredicate(commandLine.getOptionValue("c")));
            String printValue = people.printValue(nameFormat,compositePredicate);
            System.out.println(printValue);
        }
    }
}
