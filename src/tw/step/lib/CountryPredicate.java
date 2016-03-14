package tw.step.lib;

public class CountryPredicate implements Predicate,Format{
    private String country;
    public CountryPredicate(String country) {
        this.country = country;
    }

    @Override
    public boolean test(Name name, Age age, Address address, Gender gender) {
        String country = address.getCountry();
        return country.matches(this.country);
    }

    @Override
    public String apply(Name name, Age age, Address address, Gender gender) {
        if(test(name,age,address,gender))
            return this.country;
        return null;
    }
}
