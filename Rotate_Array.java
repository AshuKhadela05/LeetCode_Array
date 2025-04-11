import java.util.Scanner;

public class Rotate_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i = i + 1) {
            nums[i] = sc.nextInt();
        }

        // Input rotation count
        System.out.println("Enter k (number of rotations):");
        int k = sc.nextInt();

        // Rotate the array
        rotate(nums, k);

        // Print the rotated array
        System.out.println("Array after rotation:");
        for (int i = 0; i < nums.length; i = i + 1) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left = left + 1;
            right = right - 1;
        }
    }
}
