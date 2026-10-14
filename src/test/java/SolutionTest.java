import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Grading test file for the U1C3 Programming Challenge.
// This exact file gets copied into every student's cloned repo before
// grading, overwriting whatever they had - so editing this file has no
// effect on a student's grade.
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

    // Hidden

    @Test
    public void testConstructorDifferentModel() {
        // Catches a constructor that hardcodes "TI-84".
        Solution calc = new Solution("HP Prime", 1001);
        assertEquals("HP Prime", calc.getCalcModel());
    }

    @Test
    public void testObjectsAreIndependent() {
        // Each object gets its own copy of calcModel. Fails if calcModel
        // is made static, since then both objects would share one value.
        Solution a = new Solution("TI-84", 1001);
        Solution b = new Solution("Casio fx-300", 2002);
        assertEquals("TI-84", a.getCalcModel());
        assertEquals("Casio fx-300", b.getCalcModel());
    }

    @Test
    public void testSetterDoesNotAffectOtherObject() {
        Solution a = new Solution("TI-84", 1001);
        Solution b = new Solution("TI-84", 1001);
        a.setCalcModel("HP Prime");
        assertEquals("HP Prime", a.getCalcModel());
        assertEquals("TI-84", b.getCalcModel());
    }

    @Test
    public void testInfoAfterSetter() {
        // info() must read the instance variable, not a value saved earlier.
        Solution calc = new Solution("TI-84", 1001);
        calc.setCalcModel("Casio fx-300");
        assertEquals("This calculator is a model Casio fx-300 with id 1001", calc.info());
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

    // Hidden

    @Test
    public void testConstructorDifferentId() {
        // Catches a constructor that hardcodes 1001.
        Solution calc = new Solution("TI-84", 7);
        assertEquals(7, calc.getIdNumber());
    }

    @Test
    public void testIncrementIdTwice() {
        // Catches setting idNumber to a fixed value (like idNumber = 1)
        // instead of adding 1 to the current value.
        Solution calc = new Solution("TI-84", 1001);
        calc.incrementId();
        calc.incrementId();
        assertEquals(1003, calc.getIdNumber());
    }

    @Test
    public void testIncrementIdAfterSetter() {
        Solution calc = new Solution("TI-84", 1001);
        calc.setIdNumber(50);
        calc.incrementId();
        assertEquals(51, calc.getIdNumber());
    }

    @Test
    public void testIncrementIdDoesNotAffectOtherObject() {
        // Fails if idNumber is made static, since then both objects would
        // share one id.
        Solution a = new Solution("TI-84", 1001);
        Solution b = new Solution("TI-84", 2002);
        a.incrementId();
        assertEquals(1002, a.getIdNumber());
        assertEquals(2002, b.getIdNumber());
    }

    @Test
    public void testInfoAfterIncrementId() {
        // info() must read the current idNumber after incrementId() changes it.
        Solution calc = new Solution("TI-84", 1001);
        calc.incrementId();
        assertEquals("This calculator is a model TI-84 with id 1002", calc.info());
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

    // Hidden

    @Test
    public void testIdOnlyConstructorDifferentId() {
        // Catches a constructor that hardcodes 1001.
        Solution calc = new Solution(55);
        assertEquals(55, calc.getIdNumber());
    }

    @Test
    public void testIdOnlyConstructorInfo() {
        Solution calc = new Solution(55);
        assertEquals("This calculator is a model TI-84 with id 55", calc.info());
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

    // Hidden

    @Test
    public void testAddNegatives() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(-10.75, calc.add(-4.5, -6.25), 1e-9);
    }

    @Test
    public void testAddTenths() {
        // 0.1 + 0.2 is 0.30000000000000004 in Java, which passes because
        // assertEquals allows a small margin for doubles.
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(0.3, calc.add(0.1, 0.2), 1e-9);
    }

    @Test
    public void testSubtractWholeMinusDecimal() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(9.25, calc.subtract(10.0, 0.75), 1e-9);
    }

    @Test
    public void testMultiplyNegative() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(-7.0, calc.multiply(-3.5, 2.0), 1e-9);
    }

    // quotient

    @Test
    public void testQuotient() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(3, calc.quotient(10, 3));
    }

    @Test
    public void testQuotientLarger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(3, calc.quotient(17, 5));
    }

    // Hidden

    @Test
    public void testQuotientDoesNotRound() {
        // Catches rounding the decimal answer (3.5 rounds to 4).
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(3, calc.quotient(7, 2));
    }

    @Test
    public void testQuotientEvenLarger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(4, calc.quotient(25, 6));
    }

    @Test
    public void testQuotientBigger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(14, calc.quotient(100, 7));
    }

    // remainder

    @Test
    public void testRemainder() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(1, calc.remainder(10, 3));
    }

    @Test
    public void testRemainderLarger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(2, calc.remainder(17, 5));
    }

    // Hidden

    @Test
    public void testRemainderSmallerByLarger() {
        // Catches the numbers in the wrong order (num2 % num1), which gives 1.
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(3, calc.remainder(3, 7));
    }

    @Test
    public void testRemainderEvenLarger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(1, calc.remainder(25, 6));
    }

    @Test
    public void testRemainderBigger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(2, calc.remainder(100, 7));
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

    // Hidden

    @Test
    public void testDivisionResultNoRemainder() {
        // The " R 0" must still be included.
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("2 R 0", calc.divisionResult(10, 5));
    }

    @Test
    public void testDivisionResultSmallerByLarger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("0 R 3", calc.divisionResult(3, 7));
    }

    @Test
    public void testDivisionResultBigger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("14 R 2", calc.divisionResult(100, 7));
    }

    // coordinatePair

    @Test
    public void testCoordinatePair() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("(3, 4)", calc.coordinatePair(3, 4));
    }

    // Hidden

    @Test
    public void testCoordinatePairNegativeAndZero() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals("(-2, 0)", calc.coordinatePair(-2, 0));
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

    // Hidden

    @Test
    public void testAverageWithZero() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(4, calc.average(0, 7));
    }

    @Test
    public void testAverageLarger() {
        Solution calc = new Solution("TI-84", 1001);
        assertEquals(13, calc.average(10, 15));
    }
}
