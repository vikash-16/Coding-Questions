package DSAPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        List<Data> dataList = Arrays.asList(
                new Data(1, 2),
                new Data(1, 4),
                new Data(3, 5)
        );

        Map<Integer, Integer> result = dataList.stream()
                .collect(Collectors.groupingBy(Data::getId, Collectors.summingInt(Data::getCount)));

        // Creating a new list with the desired format
        List<Data> finalResult = result.entrySet().stream()
                .map(entry -> new Data(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        finalResult.forEach(System.out::println);
    }
}

class Data {
    private int id;
    private int count;

    public Data(int id, int count) {
        this.id = id;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "{id:" + id + ",count:" + count + "}";
    }
}
