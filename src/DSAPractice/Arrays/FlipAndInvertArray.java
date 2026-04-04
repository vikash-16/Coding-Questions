package DSAPractice.Arrays;

import java.util.Arrays;

public class FlipAndInvertArray {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(flipAndInvertImage(image));
    }
    public static int[][] flipAndInvertImage(int[][] image) {
            int n = image.length;
            for (int[] row : image)
                for (int i = 0; i * 2 < n; i++)
                    if (row[i] == row[n - i - 1])
                        row[i] = row[n - i - 1] ^= 1;
            return image;
        }
    }
