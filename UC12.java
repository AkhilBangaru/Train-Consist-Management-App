import java.util.*;

// Goods Bogie class
class GoodsBogie {
    String type;   // Cylindrical, Open, Box
    String cargo;  // Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " | Cargo: " + cargo;
    }
}

// UC12 Logic
class SafetyService {

    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        // Rule:
                        // If cylindrical → must be Petroleum
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }
}

// Main class
public class UC12_Main {
    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = SafetyService.isTrainSafe(bogies);

        System.out.println("Train Safety Compliance: " + isSafe);
    }
}
