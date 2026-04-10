import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UC10_Test {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 60)
        );

        int result = BogieService.getTotalSeatCapacity(list);

        assertEquals(130, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 60),
                new Bogie("First", 80)
        );

        int result = BogieService.getTotalSeatCapacity(list);

        assertEquals(212, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72)
        );

        int result = BogieService.getTotalSeatCapacity(list);

        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        int result = BogieService.getTotalSeatCapacity(list);

        assertEquals(0, result); // identity value
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = List.of(
                new Bogie("AC", 50),
                new Bogie("Sleeper", 50)
        );

        int result = BogieService.getTotalSeatCapacity(list);

        assertEquals(100, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = List.of(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );

        int result = BogieService.getTotalSeatCapacity(list);

        assertEquals(60, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC", 60));

        int originalSize = list.size();

        BogieService.getTotalSeatCapacity(list);

        assertEquals(originalSize, list.size());
    }
}
