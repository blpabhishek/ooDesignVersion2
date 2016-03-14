package tw.step.lib;

public class Address{
    private String city;
    private String state;
    private String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCountry() {
        return country.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!city.equals(address.city)) return false;
        if (!state.equals(address.state)) return false;
        if (!country.equals(address.country)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }
}
