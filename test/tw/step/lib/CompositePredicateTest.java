package tw.step.lib;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompositePredicateTest {

    private CompositePredicate compositePredicate;
    private Person person;

    @Before
    public void setUp() throws Exception {
        compositePredicate = new CompositePredicate();
        compositePredicate.add(new AgePredicate(31));
        compositePredicate.add(new CountryPredicate("Italy"));
        person = Person.createRecord("Sage,Roob,Female,31,Crooks ton,South Carolina,Italy");
    }

    @Test
    public void testTestAllRunsEveryPredicatePersonAndReturnsTrue() throws Exception {
        boolean testAll = compositePredicate.testAll(person);
        assertTrue(testAll);
    }

    @Test
    public void testTestAllRunsEveryPredicatePersonAndReturnsFalseIfNotMatched() throws Exception {
        person = Person.createRecord("Sage,Roob,Female,21,Crooks ton,South Carolina,Italy");
        boolean testAll = compositePredicate.testAll(person);
        assertFalse(testAll);
    }

    @Test
    public void testGetExtraFieldsGivesExtraFieldForRepresentation() throws Exception {
        String extraField = compositePredicate.getExtraField(person);
        assertEquals("31,Italy,",extraField);
    }
}