package LeetCode75.Arrays_String;

public class MoveZeros {
    public static void main(String[] args) {
        new MoveZeros().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                if (l != r) {
                    nums[l] = nums[l] ^ nums[r];
                    nums[r] = nums[l] ^ nums[r];
                    nums[l] = nums[l] ^ nums[r];
                }
                l++;
            }
            r++;
        }
    }
}
