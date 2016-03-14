package tw.step.records;

import org.apache.commons.cli.*;

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

    public CommandLine parse() {
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
}

