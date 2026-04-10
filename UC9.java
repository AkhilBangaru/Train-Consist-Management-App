import java.util.*;

// Reuse same Bogie class
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

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " | Capacity: " + capacity;
    }
}

// UC10 Logic
class BogieService {

    // UC10 method: total seats using map + reduce
    public static int getTotalSeatCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.getCapacity())        // extract capacity
                .reduce(0, Integer::sum);         // aggregate
    }
}

// Main class
public class UC10_Main {
    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 80));
        bogieList.add(new Bogie("Sleeper", 65));

        int totalSeats = BogieService.getTotalSeatCapacity(bogieList);

        System.out.println("Total Seating Capacity: " + totalSeats);
    }
}
