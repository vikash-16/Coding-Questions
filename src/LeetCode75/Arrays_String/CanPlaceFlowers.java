package LeetCode75.Arrays_String;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0, 0, 0,1},1));;
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*boolean isCanPlace = true;
        for(int i = 0; i < flowerbed.length-1; i++) {
            if(flowerbed[i] == 1) {
                isCanPlace = false;
            } else if (isCanPlace && flowerbed[i] == 0 && flowerbed[i+1] ==0) {
                n--;
                isCanPlace = false;
            }else {
                isCanPlace = true;
            }
        }
        if(isCanPlace && flowerbed[flowerbed.length-1] == 0) n--;
        return n <= 0 ? true : false;*/
        if(flowerbed.length == 1 && flowerbed[0] == 1 && n > 0){
            return false;
        }else if (flowerbed.length == 1 && flowerbed[0] == 0 && n > 1) {
            return false;
        }else if(flowerbed.length == 1) {
            return true;
        }
        for(int i = 0; i < flowerbed.length-1; i++) {
            if(i == 0 && flowerbed[i] == 0 && flowerbed[i+1]== 0) {
                n--;
                flowerbed[i] = 1;
            }else if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                n--;
                flowerbed[i] = 1;
            }else if(i == flowerbed.length-1 && flowerbed[i-1] == 0 && flowerbed[i-1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        if(flowerbed[flowerbed.length-2]==0 && flowerbed[flowerbed.length-1] == 0){
            n--;
        }
        return n <= 0 ? true : false;
    }
}
