package by.training.task3.airline.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorForPlaneParametersTest {

    @Test
    public void testIsInformationFull() {
        String[] arr = new String[]{"nas", "ds", "as", "as", "ad", "na", "d", "s", "as"};
        assertTrue(ValidatorForPlaneParameters.isInformationFull(arr));
        String[] arr2 = new String[]{"nas", "ds", "as", "as", "ad"};
        assertFalse(ValidatorForPlaneParameters.isInformationFull(arr2));
    }

    @Test
    public void isGreaterThanZero() {
        assertNotEquals(false, ValidatorForPlaneParameters.isGreaterThanZero(5));
        assertFalse(ValidatorForPlaneParameters.isGreaterThanZero(-4));
    }

    @Test
    public void testIsGreaterThanZero() {
        assertTrue(ValidatorForPlaneParameters.isGreaterThanZero(5));
        assertNotEquals(true, ValidatorForPlaneParameters.isGreaterThanZero(-4));
    }

    @Test
    public void isParseArrayElementsGreaterThanZero() {
        String[] arr = {"2", "type", "-2", "4", "6", "3", "3"};
        assertFalse(ValidatorForPlaneParameters.isParseArrayElementsGreaterThanZero(arr));
    }
}