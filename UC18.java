public class TrainConsistMgmtApp {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("==============================================\n");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search
        String searchId = "BG309";

        // Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println();

        // ---- LINEAR SEARCH LOGIC ----
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break; // Early termination
            }
        }

        // Display result
        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " not found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}
