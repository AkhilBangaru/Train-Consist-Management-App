// Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie class
class PassengerBogie {
    String type;
    int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
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

// Main class
public class UC14_Main {
    public static void main(String[] args) {

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + b1);

            PassengerBogie b2 = new PassengerBogie("AC Chair", -10); // invalid
            System.out.println("Created: " + b2);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
