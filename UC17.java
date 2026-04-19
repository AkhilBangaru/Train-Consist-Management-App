import java.util.Arrays;

public class TrainConsistMgmtApp {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("==============================================\n");

        // Create an array of bogie names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        // ---- DISPLAY ORIGINAL ARRAY ----
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // ---- SORT USING BUILT-IN METHOD ----
        Arrays.sort(bogieNames);

        // ---- DISPLAY SORTED ARRAY ----
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}
