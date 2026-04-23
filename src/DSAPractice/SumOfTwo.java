package DSAPractice;

public class SumOfTwo {
    static void main() {
        Lamda sum= (a,b)->a+b;
        int sum1 = sum.sum(10, 5);
        System.out.println(sum1);
    }
}
