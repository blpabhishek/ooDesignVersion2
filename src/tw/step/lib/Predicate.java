package tw.step.lib;

public interface Predicate{
    public boolean test(Name name, Age age, Address address, Gender gender);
    public String apply(Name name, Age age, Address address, Gender gender);
}
