import java.util.Scanner;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Step 1: Input size of the array
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];
    
        // Step 2: Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
    
        // Step 3: Call the function from the Solution class
        Solution8 solution = new Solution8();
        int result = solution.firstMissingPositive(nums);
      
        // Step 4: Output the result
        System.out.println("First missing positive number is: " + result);

        sc.close();
    }
}

// Class that contains logic to find the first missing positive integer
class Solution8 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Put each number in its correct index position if possible
        for (int i = 0; i < n; i++) {
            // Swap until the current number is out of range or already at the correct position
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;
               
                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        
        // Step 2: Find the first index i such that nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // Found the missing positive number
            }
        }

        // Step 3: All numbers are in correct place from 1 to n, so return n + 1
        return n + 1;
    }
}
