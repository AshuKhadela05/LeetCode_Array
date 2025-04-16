import java.util.Scanner;

public class MaxChunksToSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input array size
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Step 2: Input array elements
        System.out.println("Enter the elements (permutation of 0 to n-1):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 3: Call the method using Solution class
        Solution6 solution = new Solution6();
        int result = solution.maxChunksToSorted(arr);

        // Step 4: Print the number of chunks
        System.out.println("Maximum number of chunks to sort the array: " + result);

        sc.close();
    }
}

// Class with the method to calculate maximum chunks
class Solution6 {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;     // To keep track of the maximum value seen so far
        int chunks = 0;  // To count how many chunks we can form

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);    // Update the max seen so far

            // If the max value equals the current index,
            // It means all previous elements (0 to i) can form a sorted chunk
            if (max == i) {
                chunks++;    // Increment chunk count
            }
        }

        return chunks;       // Return the total number of valid chunks
    }
}
