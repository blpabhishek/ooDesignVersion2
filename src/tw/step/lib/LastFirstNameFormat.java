package tw.step.lib;

public class LastFirstNameFormat implements NameFormat {
    @Override
    public String apply(Gender gender,String firstName, String lastName) {
        return String.format("%s%s,%s",gender.getPrefix(),lastName,firstName);
    }
}
