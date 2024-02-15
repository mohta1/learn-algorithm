package mota.learn.algorithm.session7;

import java.util.*;

public class Dijkstra {

    private static Map<String, Map<String, Integer>> graph = new HashMap<>();
    private static Map<String, String> parents = new HashMap<>();
    private static Map<String, Integer> costs = new HashMap<>();
    private static List<String> processed = new ArrayList<>();

    public static void main(String[] args) {
        init();

        String node = findLowestCostNode();

        while (node != null) {
            int cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);

            for (String key : neighbors.keySet()) {
                int newCost = cost + neighbors.get(key);
                if (newCost < costs.get(key)) {
                    costs.put(key, newCost);
                    parents.put(key, node);
                }
            }

            processed.add(node);
            node = findLowestCostNode();
        }

        System.out.println(costs.get("fin"));
        System.out.println(getPath("fin"));
    }

    private static void init() {
        Map<String, Integer> startNeighbors = new HashMap<>();
        startNeighbors.put("a", 6);
        startNeighbors.put("b", 2);
        graph.put("start", startNeighbors);

        Map<String, Integer> aNeighbors = new HashMap<>();
        aNeighbors.put("fin", 1);
        graph.put("a", aNeighbors);

        Map<String, Integer> bNeighbors = new HashMap<>();
        bNeighbors.put("fin", 5);
        bNeighbors.put("a", 3);
        graph.put("b", bNeighbors);

        Map<String, Integer> finNeighbors = new HashMap<>();
        graph.put("fin", finNeighbors);

        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);
        parents.put("start", null);

        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", Integer.MAX_VALUE);
    }

    private static String findLowestCostNode() {
        int minValue = Integer.MAX_VALUE;
        String minKey = null;

        for (Object key : costs.keySet()) {
            if (!processed.contains(key) && costs.get(key) < minValue) {
                minValue = costs.get(key);
                minKey = (String) key;
            }
        }

        return minKey;
    }

    private static String getPath(String endPoint) {

        Stack stack = getStack(endPoint);

        StringBuilder path = new StringBuilder();
        while (!stack.empty()) {
            path.append(stack.pop());
            if (stack.size() > 0)
                path.append(" --> ");
        }


        return path.toString();
    }

    private static Stack<String> getStack(String endPoint) {
        Stack<String> stack = new Stack<>();

        String parent = parents.get(endPoint);
        stack.add(endPoint);

        while (parent != null) {
            stack.add(parent);
            parent = parents.get(parent);
        }

        return stack;
    }
}
