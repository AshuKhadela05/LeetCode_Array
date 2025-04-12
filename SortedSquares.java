import java.util.Scanner;

public class SortedSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input the size of the array
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        // Step 2: Create an array of size 'n'
        int[] nums = new int[n];

        // Step 3: Take array elements as input
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i = i + 1) {
            nums[i] = sc.nextInt();
        }

        // Step 4: Create object of Solution class and call the sortedSquares function
        Solution2 solution = new Solution2();
        int[] result = solution.sortedSquares(nums);

        // Step 5: Print the resulting sorted squares array
        System.out.println("Sorted squares:");
        for (int i = 0; i < result.length; i = i + 1) {
            System.out.print(result[i] + " ");
        }

        // Step 6: Close the scanner
        sc.close();
    }
}

// This class contains the logic to compute the squares of elements and return them in sorted order
class Solution2 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;             // Start pointer
        int right = n - 1;        // End pointer
        int index = n - 1;        // Position to fill in result array (from end to start)

        // Compare squares from both ends of the array
        while (left <= right) {
            int leftsquare = nums[left] * nums[left];       // Square of left element
            int rightsquare = nums[right] * nums[right];    // Square of right element

            // Put the larger square at the end of the result array
            if (leftsquare > rightsquare) {
                result[index] = leftsquare;
                left = left + 1;
            } else {
                result[index] = rightsquare;
                right = right - 1;
            }

            index = index - 1;  // Move to next position in result array (from end)
        }

        // Return the sorted squares array
        return result;
    }
}
