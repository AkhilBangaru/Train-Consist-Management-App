public class TrainconsistAppTest {

    public static void main(String[] args) {
        testCargo_SafeAssignment();
        testCargo_UnsafeAssignmentHandled();
        testCargo_CargoNotAssignedAfterFailure();
        testCargo_ProgramContinuesAfterException();
        testCargo_FinallyBlockExecution();

        System.out.println("UC15 Tests Passed");
    }

    static void testCargo_SafeAssignment() {
        TrainApp.GoodsBogie g = new TrainApp.GoodsBogie("Cylindrical");
        g.assignCargo("Petroleum");

        assert "Petroleum".equals(g.cargo);
    }

    static void testCargo_UnsafeAssignmentHandled() {
        TrainApp.GoodsBogie g = new TrainApp.GoodsBogie("Rectangular");
        g.assignCargo("Petroleum");

        assert g.cargo == null;
    }

    static void testCargo_CargoNotAssignedAfterFailure() {
        TrainApp.GoodsBogie g = new TrainApp.GoodsBogie("Rectangular");
        g.assignCargo("Petroleum");

        assert g.cargo == null;
    }

    static void testCargo_ProgramContinuesAfterException() {
        TrainApp.GoodsBogie g1 = new TrainApp.GoodsBogie("Rectangular");
        TrainApp.GoodsBogie g2 = new TrainApp.GoodsBogie("Cylindrical");

        g1.assignCargo("Petroleum");
        g2.assignCargo("Coal");

        assert "Coal".equals(g2.cargo);
    }

    static void testCargo_FinallyBlockExecution() {
        TrainApp.GoodsBogie g = new TrainApp.GoodsBogie("Rectangular");
        g.assignCargo("Petroleum");

        assert g.finallyExecuted;
    }
}
