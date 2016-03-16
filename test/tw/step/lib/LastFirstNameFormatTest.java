package tw.step.lib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LastFirstNameFormatTest {

    private NameFormat lastFirstNameFormat;

    @Before
    public void setUp() throws Exception {
        lastFirstNameFormat = new LastFirstNameFormat();
    }

    @Test
    public void testApplyShouldGiveInFirstLastFormatForFemale() throws Exception {
        String apply = lastFirstNameFormat.apply("Renu", "Singh");
        assertEquals("Ms.Singh,Renu",apply);
    }

    @Test
    public void testApplyShouldGiveInFirstLastFormatForMale() throws Exception {
        String apply = lastFirstNameFormat.apply("Ramu", "Singh");
        assertEquals("Mr.Singh,Ramu",apply);
    }

}