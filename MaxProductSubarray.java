import java.util.Scanner;

public class MaxProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take the size of the array as input
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Step 2: Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Step 3: Call the maxProduct function
        Solution3 solution = new Solution3();
        int result = solution.maxProduct(nums);

        // Step 4: Print the result
        System.out.println("Maximun product of subarray: " + result);

        sc.close();  // Close the scanner
    }
}

// This class contains the logic to find the maximum product subarray
class Solution3 {
    public int maxProduct(int[] nums) {

        // Edge case: empty array
        if (nums.length == 0) {
            return 0;
        }

        // Initialize the result and the current min/max
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        // Traverse from the second element
        for (int i = 1; i < nums.length; i++) {
            // If current number is negative, swap currentMax and currentMin
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // Update currentMax and currentMin
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);

            // Update the global maximun product
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }
}
