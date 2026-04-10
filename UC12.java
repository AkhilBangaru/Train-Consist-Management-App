import java.util.regex.Pattern;
import java.util.regex.Matcher;

// UC11 Logic
class ValidationService {

    // Regex patterns
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    // Validate Train ID
    public static boolean isValidTrainId(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    // Validate Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }
}

// Main class
public class UC11_Main {
    public static void main(String[] args) {

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean isTrainValid = ValidationService.isValidTrainId(trainId);
        boolean isCargoValid = ValidationService.isValidCargoCode(cargoCode);

        System.out.println("Train ID (" + trainId + ") valid: " + isTrainValid);
        System.out.println("Cargo Code (" + cargoCode + ") valid: " + isCargoValid);
    }
}
