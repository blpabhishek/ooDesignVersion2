package tw.step.lib;

public class AgePredicate implements Predicate{
    Integer age;
    public AgePredicate(Integer age) {
        this.age= age;
    }

    @Override
    public boolean test(Name name, Age age, Address address, Gender gender) {
        return  Integer.parseInt(age.getAge()) >= this.age;
    }
    @Override
    public String apply(Name name, Age age, Address address, Gender gender) {
        if(test(name,age,address,gender))
            return age.getAge();
        return null;
    }
}
