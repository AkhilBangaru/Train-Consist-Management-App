import java.util.*;
import java.util.stream.Collectors;

// Reuse Bogie class
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " | Capacity: " + capacity;
    }
}

// UC13 Logic
class PerformanceService {

    // Loop-based filtering
    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
    }
}

// Main class
public class UC13_Main {
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Create large dataset
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Type" + i, (i % 100) + 30));
        }

        // Loop timing
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = PerformanceService.filterWithLoop(bogies);
        long endLoop = System.nanoTime();

        // Stream timing
        long startStream = System.nanoTime();
        List<Bogie> streamResult = PerformanceService.filterWithStream(bogies);
        long endStream = System.nanoTime();

        // Results
        System.out.println("Loop Time: " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Time: " + (endStream - startStream) + " ns");

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());
    }
}
