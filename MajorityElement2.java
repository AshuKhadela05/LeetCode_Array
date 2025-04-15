import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input the number of elements
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Step 2: Input the array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Step 3: Create an instance of Solution class and call the method
        Solution5 solution = new Solution5();
        List<Integer> result = solution.majorityElement(nums);

        // Step 4: Print elements that appear more than n/3 times
        System.out.println("Elements that appear more than n/3 times:");
        if (result.isEmpty()) {
            System.out.println("None");
        } else {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }

        sc.close(); // Close the Scanner
    }
}

// Class that contains logic to find elements appearing more than n/3 times
class Solution5 {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 1; // Initial candidates (can be any two different numbers)

        // First pass: Find two potential candidates for majority elements
        for (int num : nums) {
            if (num == candidate1) {
                count1++; // Increment count for candidate1
            } else if (num == candidate2) {
                count2++; // Increment count for candidate2
            } else if (count1 == 0) {
                candidate1 = num; // Assign new candidate1
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num; // Assign new candidate2
                count2 = 1;
            } else {
                count1--; // Reduce both counts if no match
                count2--;
            }
        }

        // Second pass: Count actual frequency of the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Prepare the result list by checking if counts are greater than n/3
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        return result; // Return list of valid majority elements
    }
}

