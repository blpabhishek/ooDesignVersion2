package tw.step.lib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgePredicateTest {

    private AgePredicate predicate;

    @Before
    public void setUp() throws Exception {
        predicate = new AgePredicate(32);
    }


    @Test
    public void testApplyShouldNotGiveTheTextRepresentationOnlyIfTestConditionIsMatched() throws Exception {
        Name name = new Name("Ram", "Singh");
        Age age = new Age(23);
        Address address = new Address("Bangalore", "Karnataka", "Nepal");
        String apply = predicate.apply(name, age, address, Gender.MALE);
        assertEquals(null,apply);
    }

    @Test
    public void testApplyShouldGiveTheTextRepresentationOnlyIfTestConditionIsMatched() throws Exception {
        Name name = new Name("Ram", "Singh");
        Age age = new Age(32);
        Address address = new Address("Bangalore", "Karnataka", "India");
        String apply = predicate.apply(name, age, address, Gender.MALE);
        assertEquals("32",apply);
    }

    @Test
    public void testTestMethodTestsAgeIsGreaterThanOrEqualTo() throws Exception {
        Name name = new Name("Ram","Singh");
        Age age = new Age(32);
        Address address = new Address("Bangalore", "Karnataka", "India");
        assertTrue(predicate.test(name, age, address, Gender.MALE));
    }
}