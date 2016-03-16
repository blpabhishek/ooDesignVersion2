package tw.step.lib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstLastNameFormatTest {

    private FirstLastNameFormat firstLastNameFormat;

    @Before
    public void setUp() throws Exception {
        firstLastNameFormat = new FirstLastNameFormat();
    }

    @Test
    public void testApplyShouldGiveInFirstLastFormatForFemale() throws Exception {
        String apply = firstLastNameFormat.apply("Renu", "Singh");
        assertEquals("Ms.Renu Singh",apply);
    }

    @Test
    public void testApplyShouldGiveInFirstLastFormatForMale() throws Exception {
        String apply = firstLastNameFormat.apply("Ramu", "Singh");
        assertEquals("Mr.Ramu Singh",apply);
    }
}