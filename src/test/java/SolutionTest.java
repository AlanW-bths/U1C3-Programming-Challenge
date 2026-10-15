import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Visible tests for the U1C3 Programming Challenge.
// Grading runs these tests plus additional hidden tests, so passing every
// test here does not guarantee a full score. Editing this file has no effect
// on your grade.
public class SolutionTest {

    // Constructor, getter, and setter: calcModel

    @Test
    public void testConstructorStoresModel() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("TI-84", calc.getCalcModel());
    }

    @Test
    public void testSetterChangesModel() {
        Solution calc = new Solution("TI-84", 1001);
        calc.setCalcModel("Casio fx-300");
        assertEquals("Casio fx-300", calc.getCalcModel());
    }

    @Test
    public void testInfo() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("This calculator is a model TI-84 with id 1001", calc.info());
    }

    // Constructor, getter, and setter: idNumber

    @Test
    public void testConstructorStoresId() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(1001, calc.getIdNumber());
    }

    @Test
    public void testSetterChangesId() {
        Solution calc = new Solution("TI-84", 1001);
        calc.setIdNumber(2002);
        assertEquals(2002, calc.getIdNumber());
    }

    @Test
    public void testIncrementId() {
        Solution calc = new Solution("TI-84", 1001);
        calc.incrementId();
        assertEquals(1002, calc.getIdNumber());
    }

    // Constructor with only an id (model defaults to "TI-84")

    @Test
    public void testIdOnlyConstructorDefaultsModel() {
        Solution calc = new Solution(1001);
        assertEquals("TI-84", calc.getCalcModel());
    }

    @Test
    public void testIdOnlyConstructorStoresId() {
        Solution calc = new Solution(1001);
        assertEquals(1001, calc.getIdNumber());
    }

    // add, subtract, multiply

    @Test
    public void testAdd() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(3.75, calc.add(2.5, 1.25), 1e-9);
    }

    @Test
    public void testSubtract() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(-2.75, calc.subtract(5.5, 8.25), 1e-9);
    }

    @Test
    public void testMultiply() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(6.0, calc.multiply(1.5, 4.0), 1e-9);
    }

    // quotient

    @Test
    public void testQuotient() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(3, calc.quotient(10, 3));
    }

    // remainder

    @Test
    public void testRemainder() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(1, calc.remainder(10, 3));
    }

    // divisionResult

    @Test
    public void testDivisionResult() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("3 R 1", calc.divisionResult(10, 3));
    }

    @Test
    public void testDivisionResultLarger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("3 R 2", calc.divisionResult(17, 5));
    }

    // coordinatePair

    @Test
    public void testCoordinatePair() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("(3, 4)", calc.coordinatePair(3, 4));
    }

    // average

    @Test
    public void testAverageWhole() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(5, calc.average(4, 6));
    }

    @Test
    public void testAverageRoundsHalfUp() {
        // 3.5 rounds up to 4. Fails with (num1 + num2) / 2, which drops the .5 and gives 3.
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(4, calc.average(3, 4));
    }
}
