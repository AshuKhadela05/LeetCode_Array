import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];


        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        Solution4 solution = new Solution4();
        int result = solution.majorityElement(nums);


        System.out.println("Majority Element: " + result);

        sc.close();
    }
}

class Solution4 {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int votes= 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];


            if (votes == 0) {
                majority = num;
            }


            if (num == majority) {
                votes = votes + 1;
            } else {
                votes = votes - 1;
            }
        }

       
        return majority;
    }
}