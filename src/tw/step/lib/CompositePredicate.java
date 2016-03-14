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
            string.append(person.getPerson(predicate)+",");
        }
        string.deleteCharAt(string.length()-1);
        return new String(string);
    }
}
