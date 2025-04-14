import java.util.Scanner;

public class MajorityElement {
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

        // Step 3: Call the majorityElement method using Solution class
        Solution4 solution = new Solution4();
        int result = solution.majorityElement(nums);

        // Step 4: Print the majority element
        System.out.println("Majority Element: " + result);

        sc.close();    // Close scanner 
    }
}

// This class contains the logic to find the majority element using Boyer-Moore Voting Algorithm
class Solution4 {
    public int majorityElement(int[] nums) {
        int majority = 0;     // Candidate for majority element
        int votes= 0;         // Vote counter

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // If no current candidate, pick the current number
            if (votes == 0) {
                majority = num;
            }

            // If current number matches candidate, increment votes
            if (num == majority) {
                votes = votes + 1;
            } else {
                votes = votes - 1;
            }
        }

        // Return the majority element
        return majority;
    }
}
