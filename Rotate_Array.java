import java.util.Scanner;

public class Rotate_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input array size
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        // Step 2: Create array of size 'n'
        int[] nums = new int[n];

        // Step 3: Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i = i + 1) {
            nums[i] = sc.nextInt();
        }

        // Step 4: Input number of rotations
        System.out.println("Enter k (number of rotations):");
        int k = sc.nextInt();

        // Step 5: Rotate the array to the right by 'k' steps
        rotate(nums, k);

        // Step 6: Print the rotated array
        System.out.println("Array after rotation:");
        for (int i = 0; i < nums.length; i = i + 1) {
            System.out.print(nums[i] + " ");
        }

        sc.close(); // Close the scanner to avoid resource leak
    }

    // Rotates the array to the right by k steps using reverse method
    public static void rotate(int[] nums, int k) {
        // Handle case when k > array length
        k = k % nums.length;

        // Reverse the whole array
        reverse(nums, 0, nums.length - 1);

        // Reverse first k elements
        reverse(nums, 0, k - 1);

        // Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    // Reverses the elements of the array between left and right indices
    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            // Swap elements at positions 'left' and 'right'
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            // Move towards the middle
            left = left + 1;
            right = right - 1;
        }
    }
}

