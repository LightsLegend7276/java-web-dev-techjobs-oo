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

    @Test
    public void testToStringBeginsWithNewLine() {
        assertEquals("\n", result1.toString().substring(0,1));
    }

    @Test
    public void testToStringEndsWithNewLine() {
        assertEquals("\n", result1.toString().substring(result1.toString().length() - 1));
    }

    @Test
    public void testToStringLabels() {
        assertTrue(result3.toString().contains("ID"));
        assertTrue(result3.toString().contains("Name"));
        assertTrue(result3.toString().contains("Employer"));
        assertTrue(result3.toString().contains("Location"));
        assertTrue(result3.toString().contains("Position Type"));
        assertTrue(result3.toString().contains("Core Competency"));
    }

    @Test
    public void testToStringDataFields() {
        assertTrue(result3.toString().contains("Product Tester"));
        assertTrue(result3.toString().contains("ACME"));
        assertTrue(result3.toString().contains("Desert"));
        assertTrue(result3.toString().contains("19"));
        assertTrue(result3.toString().contains("Quality Control"));
        assertTrue(result3.toString().contains("Persistence"));
    }

    @Test
    public void testToStringResult() {
        String expected = "\nID: 7" +
                "\nName: Product Tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality Control" +
                "\nCore Competency: Persistence" +
                "\n";
        assertEquals(expected, result3.toString());
    }

    @Test
    public void testToStringEmptyDataFields() {
        Job expected = new Job();
        expected.setName("Test");
        assertTrue(expected.toString().contains("Data not available"));
    }

    @Test
    public void testToStringAllFieldsEmpty() {
        System.out.println(result1);
        assertTrue(result1.toString().contains("OOPS! This job does not seem to exist."));
    }
}
