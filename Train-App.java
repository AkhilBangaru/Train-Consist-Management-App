import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Step 1: Create Bogie class
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // For clean printing
    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

public class TrainAppUC7 {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App (UC7) ===");

        // Step 2: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Step 3: Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        // Step 4: Sort using Comparator (by capacity)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // Step 5: Display sorted bogies
        System.out.println("Bogies sorted by capacity (ascending):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Optional: descending order
        bogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        System.out.println("\nBogies sorted by capacity (descending):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}