import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UC8_Test {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 80),
                new Bogie("Chair", 50)
        );

        List<Bogie> result = BogieService.filterHighCapacityBogies(list);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = List.of(
                new Bogie("AC", 60)
        );

        List<Bogie> result = BogieService.filterHighCapacityBogies(list);

        assertTrue(result.isEmpty()); // 60 should NOT be included
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 40),
                new Bogie("Chair", 55)
        );

        List<Bogie> result = BogieService.filterHighCapacityBogies(list);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 75),
                new Bogie("First", 80)
        );

        List<Bogie> result = BogieService.filterHighCapacityBogies(list);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> list = List.of(
                new Bogie("Chair", 30),
                new Bogie("General", 40)
        );

        List<Bogie> result = BogieService.filterHighCapacityBogies(list);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> list = List.of(
                new Bogie("AC", 70),
                new Bogie("First", 90)
        );

        List<Bogie> result = BogieService.filterHighCapacityBogies(list);

        assertEquals(list.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        List<Bogie> result = BogieService.filterHighCapacityBogies(list);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("Chair", 40));

        int originalSize = list.size();

        BogieService.filterHighCapacityBogies(list);

        assertEquals(originalSize, list.size()); // original unchanged
    }
}
