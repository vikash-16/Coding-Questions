package DSAPractice.Arrays;

import java.util.Arrays;

public class BuyTwoChocolates {
    public static void main(String[] args) {
        int []prices = {1,2,2};
        int money = 3;
        System.out.println(new BuyTwoChocolates().buyChoco(prices,money));
    }
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int totalPrice = prices[0] + prices[1];
        return money-totalPrice >= 0 ? money-totalPrice: money;
    }
}
