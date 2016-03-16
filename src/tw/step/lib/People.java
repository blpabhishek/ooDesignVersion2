package tw.step.lib;

import java.util.HashSet;
import java.util.List;

public class People {
    private HashSet<Person> collection;
    private People() {
        this.collection = new HashSet<>();
    }
    public boolean addPerson(Person p){
        return collection.add(p);
    }
    public static People createPeople(List<String> strings) {
        People people = new People();
        for (String string : strings) {
            Person record = Person.createRecord(string);
            people.addPerson(record);
        }
        return people;
    }

    @Override
    public String toString() {
        return collection.toString();
    }

    public People filter(CompositePredicate predicates) {
        People people = new People();
        for (Person person : collection) {
            if(predicates.testAll(person))
                people.addPerson(person);
        }
        return people;
    }


    public String printLabel(NameFormat nameFormat, CompositePredicate predicates) {
        StringBuilder string = new StringBuilder();
        for (Person person : collection) {
            string.append(person.getName(nameFormat) + "," + predicates.getExtraField(person) + "\n");
            string.deleteCharAt(string.length()-2);
        }
        return new String(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (collection != null ? !collection.equals(people.collection) : people.collection != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return collection != null ? collection.hashCode() : 0;
    }
}