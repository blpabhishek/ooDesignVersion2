package tw.step.lib;

public class Person {
    private Name name;
    private Address address;
    private Gender gender;
    private Age age;
    private Person(Name name,Gender gender,Age age,Address address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public String getName(NameFormat nameFormat){
        return name.getName(nameFormat,gender);
    }

    public String getPerson(Format format){
        return format.apply(name,age,address,gender);
    }

    public static Person createRecord(String value) {
        String [] records =value.split(",");
        if(records.length!=7)
            throw new RuntimeException("Every record should be in [firstName,lastName,gender,age,city,state,country] form");
        try {
            Integer.parseInt(records[3]);
        }catch (NumberFormatException nfe){
            throw new NumberFormatException("Age should be an Integer");
        }
        return createPerson(records);
    }
    private static Person createPerson(String[] str){
        Name name = new Name(str[0], str[1]);
        Gender gender = (str[2].contains("F"))?Gender.FEMALE:Gender.MALE;
        Age age = new Age(Integer.parseInt(str[3]));
        Address address = new Address(str[4],str[5],str[6]);
        Person person = new Person(name,gender,age,address);
        return  person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!address.equals(person.address)) return false;
        if (gender != person.gender) return false;
        if (!age.equals(person.age)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Person %s%s,%s,%s",gender,name,address,age);
    }
}
