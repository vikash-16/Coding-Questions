package DSAPractice;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExample {
    static int test(I1 t1,int a, int b) {
        return t1.twoNumber(a,b);
    }
    public static void main(String[] args) {
        List<Integer> arr = List.of(10,20,30,40,50,1,4,5);
        List<Integer> filterData = arr.stream().filter(i -> (i % 2 == 0)).collect(Collectors.toList());
        System.out.println(filterData.toString());
        List<Integer> mapData = filterData.stream().map(i -> i + 10).collect(Collectors.toList());
        System.out.println(mapData.toString());

        System.out.println(test(((a,b)->a*b),10,5));
        I1 test = (a,b)->((int)a/b);
        System.out.println(test.twoNumber(10,5));


    }
}
interface I1 {
    abstract int twoNumber(int a, int b);
}
