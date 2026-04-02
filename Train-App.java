import java.util.HashMap;
import java.util.Map;

public class TrainAppUC6 {

    public static void main(String[] args) {

        // Step 1: Welcome message
        System.out.println("=== Train Consist Management App (UC6) ===");

        // Step 2: Create HashMap for bogie -> capacity
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Step 3: Insert bogie capacities
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo", 100); // optional goods example

        // Step 4: Display all bogie capacities
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Step 5: Example lookup (important concept)
        System.out.println("\nCapacity of Sleeper: " + bogieCapacityMap.get("Sleeper"));
    }
}