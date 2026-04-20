package LeetCode75.Arrays_String;

import java.util.*;

public class EvaluateDivision {
    static void main() {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        double[] doubles = evaluateDivision.calcEquation(equations, values, queries);
        Arrays.stream(doubles).forEach(System.out::println);


    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        double[] answer = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                answer[i] = -1.0;
            }else {
                HashSet<String>vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(dividend,divisor,graph,vis,ans,temp);
                answer[i] = ans[0];
            }
        }
        return answer;
    }

    private void dfs(String src, String dest, HashMap<String, HashMap<String, Double>> graph, HashSet<String> vis, double[] ans, double temp) {
        if (vis.contains(src))
        return;

        vis.add(src);
        if (src.equals(dest)) {
            ans[0] = temp;
            return;
        }

        for (Map.Entry<String, Double> entry : graph.get(src).entrySet()) {
            String ne = entry.getKey();
            double val = entry.getValue();
            dfs(ne, dest, graph, vis, ans, temp * val);
        }
    }

    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String,HashMap<String, Double>>graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            String s = equations.get(i).get(0);
            String d = equations.get(i).get(1);
            graph.putIfAbsent(s,new HashMap<>());
            graph.get(s).put(d,values[i]);
            graph.putIfAbsent(d,new HashMap<>());
            graph.get(d).put(s,1/values[i]);
        }
        return graph;
    }
}
