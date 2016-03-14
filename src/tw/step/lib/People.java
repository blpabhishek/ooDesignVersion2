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

    public String printValue(NameFormat nameFormat, CompositePredicate predicates) {
        StringBuilder string = new StringBuilder();
        for (Person person : collection) {
            if(predicates.testAll(person))
                string.append(person.getName(nameFormat)+","+predicates.getExtraField(person)+"\n");
        }
        return new String(string);
    }
}