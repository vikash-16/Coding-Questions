package DSAPractice.Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    public static void main(String[] args) {
        List<List<String>> paths = List.of(List.of("London","New York"),List.of("New York","Lima"),List.of("Lima","Sao Paulo"));
        System.out.println(new DestinationCity().destCity(paths));
    }
    public String destCity(List<List<String>> paths) {
        Map<String,String>graph = new HashMap<>();
        for(List<String> path : paths) {
            graph.put(path.get(0),path.get(1));
        }
        for(List<String>path: paths) {
            if(!graph.containsKey(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
