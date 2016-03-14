package tw.step.lib;

public interface Predicate extends Format{
    boolean test(Name name, Age age, Address address, Gender gender);
}
