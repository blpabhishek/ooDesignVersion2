package tw.step.lib;

public class FirstLastNameFormat implements NameFormat {
    @Override
    public String apply(String firstName, String lastName) {
        return String.format("%s %s",firstName,lastName);
    }
}
