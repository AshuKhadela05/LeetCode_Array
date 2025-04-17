import java.util.Scanner;

public class MaxChunksToSortedII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input the array size
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Step 2: Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 3: Create object of Solution class and call the method
        Solution7 solution = new Solution7();
        int result = solution.maxChunksToSorted(arr);

        // Step 4: Output the result
        System.out.println("Maximum number of chunks to sort the array: " + result);

        sc.close(); // Close the scanner
    }
}

// Class that contains the logic for finding max chunks
class Solution7 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n + 1]; // rightMin[i] stores min value from i to end
        rightMin[n] = Integer.MAX_VALUE; // rightmost boundary has max value initially

        // Step 1: Build rightMin[] array by moving from right to left
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        int chunks = 0; // counter for valid chunks
        int leftMax = Integer.MIN_VALUE; // max value from left to current index

        // Step 2: Traverse from left to right to find valid cut points
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);

            // If the max in left part is <= min in right part, we can split here
            if (leftMax <= rightMin[i + 1]) {
                chunks++; // valid chunk found
            }
        }

        return chunks; // return total chunks
    }
}
