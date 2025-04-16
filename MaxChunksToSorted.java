import java.util.Scanner;

public class MaxChunksToSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] arr = new int[n];


        System.out.println("Enter the elements (permutation of 0 to n-1):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        Solution6 solution = new Solution6();
        int result = solution.maxChunksToSorted(arr);


        System.out.println("Maximum number of chunks to sort the array: " + result);

        sc.close();
    }
}


class Solution6 {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunks = 0;

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);



            if (max == i) {
                chunks++;
            }
        }

        return chunks;  
    }
}
