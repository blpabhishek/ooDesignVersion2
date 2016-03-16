package tw.step.records;

import org.apache.commons.cli.*;
import tw.step.lib.*;

import java.util.List;

public class ArgumentParser {
    private Options options;
    private String[] args;

    public ArgumentParser(String[] args) {
        this.options = new Options();
        this.args = args;
    }

    public void setOptions() {
        options.addOption("f", false, "firstName");
        options.addOption("l", false, "lastName");
        options.addOption("a","age",true, "age");
        options.addOption("c","country",true,"country");
        options.addOption("h", false, "help");
    }

    private CommandLine parse() {
        HelpFormatter formatter = new HelpFormatter();
        if (args.length == 0)
            formatter.printHelp("PrintLabel", options);
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            formatter.printHelp("PrintLabel", options);
            return null;
        }
        return cmd;
    }

    public NameFormat getFormat(){
        CommandLine commandLine = parse();
        NameFormat nameFormat = new FirstLastNameFormat();
        if(commandLine.hasOption("f"))
            nameFormat = new FirstLastNameFormat();
        if(commandLine.hasOption("l"))
            nameFormat = new LastFirstNameFormat();
        return nameFormat;
    }
    public CompositePredicate getPredicates() {
        CommandLine commandLine = parse();
        CompositePredicate compositePredicate = new CompositePredicate();
        if(commandLine.hasOption("a"))
            compositePredicate.add( new AgePredicate(Integer.parseInt(commandLine.getOptionValue("a"))));
        if(commandLine.hasOption("c"))
            compositePredicate.add(new CountryPredicate(commandLine.getOptionValue("c")));
        return compositePredicate;
    }
    public List<String> getFiles(){
        CommandLine commandLine = parse();
        return commandLine.getArgList();
    }
}

