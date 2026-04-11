import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UC13_Test {

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = List.of(
                new Bogie("A", 70),
                new Bogie("B", 50)
        );

        List<Bogie> result = PerformanceService.filterWithLoop(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = List.of(
                new Bogie("A", 70),
                new Bogie("B", 50)
        );

        List<Bogie> result = PerformanceService.filterWithStream(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = List.of(
                new Bogie("A", 70),
                new Bogie("B", 50),
                new Bogie("C", 80)
        );

        List<Bogie> loopResult = PerformanceService.filterWithLoop(list);
        List<Bogie> streamResult = PerformanceService.filterWithStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("T", i));
        }

        long start = System.nanoTime();
        PerformanceService.filterWithLoop(list);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("T", i));
        }

        List<Bogie> result = PerformanceService.filterWithStream(list);

        assertNotNull(result);
        assertTrue(result.size() >= 0);
    }
}
