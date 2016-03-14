package tw.step.lib;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PeopleTest {

    private People people;

    @Before
    public void testSetup() throws Exception {
        List<String> str= new LinkedList<>();
        str.add("Sage,Roob,Female,31,Crooks ton,South Carolina,Qatar");
        str.add("Winfield,Sanford,Male,30,New Alanna,Georgia,Bangladesh");
        people = People.createPeople(str);
    }

    @Test
    public void testAddPersonShouldBeAbleToAddANewRecord() throws Exception {
        Person person = Person.createRecord("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        assertTrue(people.addPerson(person));
    }

    @Test
    public void testPrintValueGivesTheResultAccordingToNameFormatAndPredicates() throws Exception {
        NameFormat format = new LastFirstNameFormat();
        CompositePredicate predicates = new CompositePredicate();
        predicates.add(new CountryPredicate("Qatar"));
        String printValue = people.printValue(format, predicates);
        assertEquals("Ms.Roob,Sage,Qatar\n",printValue);
    }

    @Test
    public void testPrintValueGivesTheResultAccordingToNameFormatAndAllPredicates() throws Exception {
        NameFormat format = new LastFirstNameFormat();
        CompositePredicate predicates = new CompositePredicate();
        predicates.add(new CountryPredicate("Qatar"));
        predicates.add(new AgePredicate(31));
        String printValue = people.printValue(format, predicates);
        assertEquals("Ms.Roob,Sage,Qatar,31\n",printValue);
    }
}