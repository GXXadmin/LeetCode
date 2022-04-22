/**
 * User:郭星星
 * Date:2021/10/7
 * Time:15:29
 */
public class 图像渲染733 {
    public static void main(String[] args) {
        Solution733 s733 = new Solution733();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        image = s733.floodFill(image, sr, sc, newColor);
        System.out.println(image);
    }
}

class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return FFF(image, sr, sc, newColor, image[sr][sc]);
    }

    public int[][] FFF(int[][] image, int sr, int sc, int newColor, int num) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor || image[sr][sc] != num) {

        } else {
            int temp = image[sr][sc];
            image[sr][sc] = newColor;
            FFF(image, sr - 1, sc, newColor, temp);
            FFF(image, sr + 1, sc, newColor, temp);
            FFF(image, sr, sc - 1, newColor, temp);
            FFF(image, sr, sc + 1, newColor, temp);
        }
        return image;
    }
}