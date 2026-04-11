import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC14_Test {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie b = new PassengerBogie("Sleeper", 72);
            assertEquals(72, b.getCapacity());
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC", -10);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", -5);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie b = new PassengerBogie("First Class", 80);

        assertEquals("First Class", b.getType());
        assertEquals(80, b.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new PassengerBogie("Sleeper", 70);
            new PassengerBogie("AC", 60);
            new PassengerBogie("First", 80);
        });
    }
}
