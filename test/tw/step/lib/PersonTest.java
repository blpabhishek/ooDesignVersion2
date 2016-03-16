package tw.step.lib;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp() throws Exception {
        person = Person.createRecord("Sage,Roob,Female,31,Crooks ton,South Carolina,Qatar");
    }

    @Test
    public void testShouldBeAbleToCompare() throws Exception {
        assertEquals(person,person);
        Person newPerson = Person.createRecord("Sage,Roob,Female,31,Crooks ton,South Carolina,Qatar");
        assertEquals(person,newPerson);
    }

    @Test
    public void testCreateRecordReturnsErrorIfRecordIsNotValid() throws Exception {
        String record = "Gavin,Hyatt,Male,36,Crooks ton,Illinois,Romania,Somalia";
        thrown.expect(RuntimeException.class);
        //thrown.expectMessage("Every record should be in [firstName,lastName,gender,age,city,state,country] form");
        Person person = Person.createRecord(record);
    }

    @Test
    public void testCreateRecordReturnsErrorIfAgeIsNotValid() throws Exception {
        String record = "Gavin,Hyatt,Male,Thirteen,Crooks ton,Illinois,Romania";
        thrown.expect(NumberFormatException.class);
        //thrown.expectMessage("Age should be an Integer");
        Person person = Person.createRecord(record);
    }

    @Test
    public void testGetNameShouldCallGetNameOnNameWithNameFormatAndGender(){
        String name = person.getName(new NameFormat() {
            @Override
            public String apply(String firstName, String lastName) {
                return "NameWithFields";
            }
        });
        assertEquals("NameWithFields",name);
    }


//    @Test
//    public void testGetPersonShouldCallFormatApplyOnWithNameAgeAddressAndGender() {
//        String person = this.person.getPerson(new Format() {
//            @Override
//            public String apply(Name name, Age age, Address address, Gender gender) {
//                return "NameWithFields";
//            }
//        });
//        assertEquals("NameWithFields",person);
//    }
}