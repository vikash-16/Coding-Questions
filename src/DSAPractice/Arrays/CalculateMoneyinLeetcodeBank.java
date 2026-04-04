package DSAPractice.Arrays;

public class CalculateMoneyinLeetcodeBank {
    public static void main(String[] args) {
        int n = 26;
        System.out.println(new CalculateMoneyinLeetcodeBank().totalMoney(n));
    }
    public int totalMoney(int n) {
        if(n <= 7) {
            return sumOfNumbers(n);
        }
        int noOfFullDay = n/7;
        int remainingDay = n%7;
        int result = noOfFullDay * (sumOfNumbers(7)) + sumOfNumbers(noOfFullDay-1) * 7+ noOfFullDay*remainingDay+sumOfNumbers(remainingDay);
        return result;
    }

    private int sumOfNumbers(int n) {
        return (n*(n+1))/2;
    }
}
