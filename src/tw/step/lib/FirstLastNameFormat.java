package tw.step.lib;

public class FirstLastNameFormat implements NameFormat {
    @Override
    public String apply(Gender gen,String firstName, String lastName) {
        return String.format("%s%s %s",gen.getPrefix(),firstName,lastName);
    }
}
