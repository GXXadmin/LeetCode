package 剑指offer;

public class Offer_04_二维数组中的查找 {
    public static void main(String[] args) {
        int[][] nums = {new int[]{1, 4, 7, 11, 15}, new int[]{2, 5, 8, 12, 19}, new int[]{3, 6, 9, 16, 22}, new int[]{10, 13, 14, 17, 24}, new int[]{18, 21, 23, 26, 30}};
        System.out.println(Offer_04_二维数组中的查找.findNumberIn2DArray(nums, 20));

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int n = 0;
        int m = matrix[0].length - 1;
        while (n < matrix.length && m >= 0) {
            if (matrix[n][m] == target) {
                return true;
            } else if (matrix[n][m] < target) {
                n++;
            } else {
                m--;
            }
        }
        return false;
    }
}
