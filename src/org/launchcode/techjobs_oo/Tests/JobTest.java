package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job result1;
    Job result2;
    Job result3;
    Job result4;

    @Before
    public void setUp() {
        result1 = new Job();
        result2 = new Job();
        result3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        result4 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(result1.getId() + 1, result2.getId());
        assertTrue(result1.getId() != result2.getId());
        assertFalse(result1.getId() == result2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(result3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", result3.getCoreCompetency().getValue());

        assertTrue(result3.getEmployer() instanceof Employer);
        assertEquals("ACME", result3.getEmployer().getValue());

        assertTrue(result3.getLocation() instanceof Location);
        assertEquals("Desert", result3.getLocation().getValue());

        assertTrue(result3.getPositionType() instanceof PositionType);
        assertEquals("Quality Control", result3.getPositionType().getValue());

        assertEquals("Product Tester", result3.getName());
    }

    @Test
    public void testJobsForEquality() {

        assertNotEquals(result3, result4);

    }
}
