package Interview;

public class HouseRobb {
    public static void main(String[] args) {
        int[] ints = {5, 1,3, 5,2, 6};
        int i = new HouseRobb().houseRobb(ints);
        System.out.println(i);
    }
    public int houseRobb(int [] nums) {
        int curRob = 0;
        return houseRobbHelper(0,nums,curRob);
    }

    private int  houseRobbHelper(int i, int[] nums, int curRob) {
        if(i >= nums.length) return curRob;
        return Math.max(houseRobbHelper(i+2,nums,curRob+nums[i]),houseRobbHelper(i+1,nums,curRob));
    }
}

