package tw.step.lib;

public class LastFirstNameFormat implements NameFormat {
    @Override
    public String apply(String firstName, String lastName) {
        return String.format("%s,%s",lastName,firstName);
    }
}
