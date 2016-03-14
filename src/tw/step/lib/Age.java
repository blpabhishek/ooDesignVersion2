package tw.step.lib;

public class Age {
    private Integer age;

    public Age(Integer age) {
        this.age = age;
    }

    public String getAge() {
        return age.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Age age1 = (Age) o;

        if (!age.equals(age1.age)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return age.hashCode();
    }
}
