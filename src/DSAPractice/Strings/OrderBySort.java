package DSAPractice.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderBySort {
    public static void main(String[] args) {
        List<String> orders = Arrays.asList("id1 233 232 232", "12d amazon kindle", "13d amazon kindle", "id2 54352 23", "id6 amazon book");
        System.out.println(new OrderBySort().prioritize(orders));
    }
    public List<String> prioritize(List<String> orders) {
        List<String> nonPrimes = orders.stream().filter(o -> isNum(o.split(" ")[1])).collect(Collectors.toList());

        List<String> primes = orders.stream().filter(o -> !isNum(o.split(" ")[1]))
                .sorted(this::compareOrders).collect(Collectors.toList());

        primes.addAll(nonPrimes);

        return primes;
    }

    private int compareOrders(String o1, String o2) {
        String[] split1 = o1.split(" ", 2);
        String meta1 = split1[1];
        String id1 = split1[0];

        String[] split2 = o2.split(" ", 2);
        String meta2 = split2[1];
        String id2 = split2[0];

        if (meta1.equals(meta2)) {
            return id1.compareTo(id2);
        }
        return meta1.compareTo(meta2);
    }

    private boolean isNum(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
