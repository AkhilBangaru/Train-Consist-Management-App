import java.util.ArrayList;
import java.util.List;

// Bogie class (can match your UC7 structure)
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

// UC8 Logic Class
class BogieService {

    // Core UC8 method (important for testing)
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60) // STRICT CONDITION
                .toList(); // creates new list
    }
}

// Main class
public class UC8_Main {
    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 80));
        bogieList.add(new Bogie("Sleeper", 55));
        bogieList.add(new Bogie("AC Chair", 65));

        List<Bogie> filtered = BogieService.filterHighCapacityBogies(bogieList);

        System.out.println("Filtered Bogies (Capacity > 60):");
        filtered.forEach(System.out::println);

        System.out.println("\nOriginal List (unchanged):");
        bogieList.forEach(System.out::println);
    }
}
