package arrays;
/*
Write a program to process an unsorted integer array by sorting it in ascending order and then removing all duplicate elements without using any built-in Java collection libraries (like HashSet) or built-in sorting methods (like Arrays.sort()).
Requirements:
Part 1: Manual Sort
 Implement a sorting algorithm (e.g., Quicksort) to arrange the elements in non-decreasing order.
 The sorting should be done in-place to optimize space complexity.
Part 2: Remove Duplicates
 Once sorted, remove all duplicate values such that each unique element appears only once.
 The relative order of the unique elements must be maintained.
 Return the number of unique elements (k).
 The first k elements of the array should contain the unique values.
 */

public class ManualSortAndRemove {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3, 1, 5, 2};
        ManualSortAndRemove sol = new ManualSortAndRemove();

        // Step 1: Sort the array (Quicksort)
        sol.quickSort(nums, 0, nums.length - 1);

        // Step 2: Remove duplicates (Two Pointers)
        int k = sol.removeDuplicates(nums);

        // Print the result
        System.out.print("Array after sorting and removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    // --- Custom Quicksort implementation ---
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);  // Sort left side
            quickSort(arr, pivotIndex + 1, high); // Sort right side
        }
    }

    private int partition(int[] arr, int low, int high) {
        // Choose the last element as the pivot
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with the element at i + 1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the position of the pivot
    }

    // --- LeetCode 26: Remove Duplicates from Sorted Array ---
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // Pointer for the last unique element found
        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Move it to the next available position
            }
        }
        return i + 1; // Number of unique elements
    }
}
