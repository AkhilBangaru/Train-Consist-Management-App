import java.util.*;
import java.util.stream.Collectors;

// Reuse same Bogie class
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " | Capacity: " + capacity;
    }
}

// UC9 Logic
class BogieService {

    // UC9 grouping method
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }
}

// Main class
public class UC9_Main {
    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("Sleeper", 65));
        bogieList.add(new Bogie("First Class", 80));
        bogieList.add(new Bogie("AC Chair", 55));

        Map<String, List<Bogie>> grouped =
                BogieService.groupBogiesByType(bogieList);

        System.out.println("Grouped Bogies:");
        grouped.forEach((type, list) -> {
            System.out.println("\nType: " + type);
            list.forEach(System.out::println);
        });
    }
}
