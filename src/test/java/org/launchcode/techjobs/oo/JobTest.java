package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job productTester = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(productTester.getEmployer() instanceof Employer);
        assertEquals("ACME", productTester.getEmployer().toString());
        assertTrue(productTester.getLocation() instanceof Location);
        assertEquals("Desert", productTester.getLocation().toString());
        assertTrue(productTester.getPositionType() instanceof PositionType);
        assertEquals("Quality control", productTester.getPositionType().toString());
        assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", productTester.getCoreCompetency().toString());
        assertTrue(productTester instanceof Job);
        assertEquals("Product tester", productTester.getName());
    }

    @Test
    public void testJobsForEquality() {
        Job job3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job acmeProductTester = new Job("Product tester", new Employer(""),
                new Location("Desert"), new PositionType(""),
                new CoreCompetency(""));
//        String firstChar = String.valueOf(acmeProductTester.toString().charAt(0));
//        String lastChar = String.valueOf(acmeProductTester.toString().charAt(acmeProductTester.toString().length()-1));
//        assertEquals(firstChar, lineSeparator());
        assertTrue(acmeProductTester.toString().startsWith(System.lineSeparator()));
//        assertEquals(lastChar, lineSeparator());
        assertTrue(acmeProductTester.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String expectedString = lineSeparator() + "ID: 4" + lineSeparator() +
                "Name: Product tester" + lineSeparator() + "Employer: ACME" + lineSeparator() +
                "Location: Desert" + lineSeparator() + "Position Type: Quality control" +
                lineSeparator() + "Core Competency: Persistence" + lineSeparator();
        Job acmeProductTester = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals(expectedString, acmeProductTester.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String expectedString = lineSeparator() + "ID: 3" + lineSeparator() +
                "Name: Product tester" + lineSeparator() + "Employer: Data not available" + lineSeparator() +
                "Location: Desert" + lineSeparator() + "Position Type: Data not available" +
                lineSeparator() + "Core Competency: Data not available" + lineSeparator();
        Job acmeProductTester = new Job("Product tester", new Employer(""),
                new Location("Desert"), new PositionType(""),
                new CoreCompetency(""));
        assertEquals(expectedString, acmeProductTester.toString());

    }
}
