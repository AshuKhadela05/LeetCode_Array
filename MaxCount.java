import java.util.Scanner;

public class MaxCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix dimensions m x n
        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();

        // Input number of operations
        System.out.print("Enter number of operations: ");
        int numOps = sc.nextInt();

        int[][] ops = new int[numOps][2];

        // Input each operation (a, b)
        System.out.println("Enter operations (a b):");
        for (int i = 0; i < numOps; i++) {
            ops[i][0] = sc.nextInt();
            ops[i][1] = sc.nextInt();
        }

        // Call the method in Solution class
        Solution9 sol = new Solution9();
        int result = sol.maxCount(m, n, ops);

        // Output the result
        System.out.println("Maximum count of largest integer after operations: " + result);

        sc.close();
    }
}

// Logic class for computing the result
class Solution9 {
    public int maxCount(int m, int n, int[][] ops) {
        // Initialize minimum values to full matrix size
        int minRow = m;
        int minCol = n;

        // Traverse through all operations to find the smallest affected area
        for (int i = 0; i < ops.length; i++) {
            int[] op = ops[i];
            minRow = Math.min(minRow, op[0]);  // Find minimum row value
            minCol = Math.min(minCol, op[1]);  // Find minimum column value
        }

        // The maximum value is in the overlap of all operations — a rectangle
        return minRow * minCol;
    }
}
