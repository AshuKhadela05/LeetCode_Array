import java.util.Scanner;

public class Rotate_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input size of the array
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Step 2: Input the array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Step 3: Input number of rotations
        System.out.println("Enter k (number of rotations):");
        int k = sc.nextInt();

        // Step 4: Call the rotate method using Solution class
        Solution1 solution = new Solution1();
        solution.rotate(nums, k);

        // Step 5: Print the rotated array
        System.out.println("Array after rotation:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close(); // Close the scanner
    }
}

// This class contains the logic to rotate an array to the right by k steps
class Solution1 {
    public void rotate(int[] nums, int k) {
        // Handle case when k is larger than array length
        k = k % nums.length;

        // Step 1: Reverse the whole array
        reverse(nums, 0, nums.length - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the rest of the elements
        reverse(nums, k, nums.length - 1);
    }

    // Reverses the elements from index 'left' to 'right'
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left = left + 1;
            right = right - 1;
        }
    }
}
