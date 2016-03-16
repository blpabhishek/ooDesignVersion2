package tw.step.lib;

import java.util.LinkedList;

public class CompositePredicate extends LinkedList<Predicate> {
    public boolean testAll(Person person){
        for (Predicate predicate : this) {
            if(person.getPerson(predicate)==null)
            return false;
        }
        return true;
    }
    public String getExtraField(Person person){
        StringBuilder string= new StringBuilder();
        for (Predicate predicate : this) {
            String extraFields = person.getPerson(predicate);
            string.append(extraFields+",");
        }
        return new String(string);
    }
}
