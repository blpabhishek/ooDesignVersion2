package tw.step.lib;

public enum Gender{
    MALE("Mr."),
    FEMALE("Ms.");
    String prefix;
    Gender(String str) {
        this.prefix = str;
    }
    public String getPrefix(){
        return prefix.toString();
    }
}
