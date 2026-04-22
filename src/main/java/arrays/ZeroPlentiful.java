package arrays;

/* An array is considered zero-plentiful if it contains at least one span of zeros and every span of zeros contains at least four elements.
Your Task:
Write a function named isZeroPlentiful that accepts an integer array a and returns:
The number of zero spans in the array if the array is zero-plentiful.
0 if the array is not zero-plentiful or if it contains no zeros at all. */

public class ZeroPlentiful {
    public static int isZeroPlentiful(int[] a) {
        if (a == null || a.length < 4) {
            return 0;
        }

        int totalZeroSequences = 0;
        int i = 0;

        while (i < a.length) {
            if (a[i] == 0) {
                int count = 0;
                // Count consecutive zeros
                while (i < a.length && a[i] == 0) {
                    count++;
                    i++;
                }

                // If any sequence of zeros is less than 4, the entire array is invalid
                if (count < 4) {
                    return 0;
                } else {
                    totalZeroSequences++;
                }
            } else {
                i++;
            }
        }
        return totalZeroSequences;
    }

    public static void main(String[] args) {
        // Test cases from the exam
        System.out.println("Result 1: " + isZeroPlentiful(new int[]{0, 0, 0, 0, 0, 1})); // Expected: 1
        System.out.println("Result 2: " + isZeroPlentiful(new int[]{1, 2, 0, 0, 0, 0, 2, -18, 0, 0, 0, 0, 0, 12})); // Expected: 2
        System.out.println("Result 3: " + isZeroPlentiful(new int[]{0, 0, 0, 3, 0, 0, 0, 0, 0, 0})); // Expected: 0 (one sequence is only 3)
        System.out.println("Result 3: " + isZeroPlentiful(new int[]{0})); // Expected: 0
        System.out.println("Result 3: " + isZeroPlentiful(new int[]{})); // Expected: 0
    }
}