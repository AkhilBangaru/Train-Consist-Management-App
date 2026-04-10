import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11_Test {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(ValidationService.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(ValidationService.isValidTrainId("TRAIN12"));
        assertFalse(ValidationService.isValidTrainId("TRN12A"));
        assertFalse(ValidationService.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(ValidationService.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(ValidationService.isValidCargoCode("PET-ab"));
        assertFalse(ValidationService.isValidCargoCode("PET123"));
        assertFalse(ValidationService.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(ValidationService.isValidTrainId("TRN-123"));
        assertFalse(ValidationService.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(ValidationService.isValidCargoCode("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(ValidationService.isValidTrainId(""));
        assertFalse(ValidationService.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(ValidationService.isValidTrainId("TRN-1234XYZ"));
        assertFalse(ValidationService.isValidCargoCode("PET-ABCD"));
    }
}
