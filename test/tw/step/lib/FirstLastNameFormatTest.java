package tw.step.lib;

import com.sun.tools.javac.jvm.Gen;
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
        String apply = firstLastNameFormat.apply(Gender.FEMALE, "Renu", "Singh");
        assertEquals("Ms.Renu Singh",apply);
    }

    @Test
    public void testApplyShouldGiveInFirstLastFormatForMale() throws Exception {
        String apply = firstLastNameFormat.apply(Gender.MALE, "Ramu", "Singh");
        assertEquals("Mr.Ramu Singh",apply);
    }
}