public class TrainconsistAppTest {

    public static void main(String[] args) {
        testSort_BasicSorting();
        testSort_AlreadySortedArray();
        testSort_DuplicateValues();
        testSort_SingleElementArray();
        testSort_AllEqualValues();

        System.out.println("UC16 Tests Passed");
    }

    static void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        TrainconsistApp.bubbleSort(arr);

        assert isEqual(arr, new int[]{24, 56, 60, 70, 72});
    }

    static void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        TrainconsistApp.bubbleSort(arr);

        assert isEqual(arr, new int[]{24, 56, 60, 70, 72});
    }

    static void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        TrainconsistApp.bubbleSort(arr);

        assert isEqual(arr, new int[]{24, 56, 56, 72});
    }

    static void testSort_SingleElementArray() {
        int[] arr = {50};
        TrainconsistApp.bubbleSort(arr);

        assert isEqual(arr, new int[]{50});
    }

    static void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        TrainconsistApp.bubbleSort(arr);

        assert isEqual(arr, new int[]{40, 40, 40});
    }

    static boolean isEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
