package org.example.early_math.graph;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> costs = new HashMap<>();
        Map<String, LinkedList<String>> parents = new HashMap<>();

        putValuesInGraph(graph);
        putValuesInCosts(costs);
        putValuesInParents(parents);

        System.out.println(dijkstra(graph, costs, parents));

    }

    private static LinkedList<String> dijkstra(Map<String, Map<String, Integer>> graph,
                                               Map<String, Integer> costs, Map<String, LinkedList<String>> parents) {
        Set<String> processed = new HashSet<>();
        String node = findLowestCostNode(costs, processed);

        while (node != null) {
            int cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);

            for (String n : neighbors.keySet()) {
                int newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    LinkedList<String> parentList = parents.get(n);
                    if (parentList == null) {
                        parentList = new LinkedList<>();
                        parents.put(n, parentList);
                    } else {
                        parentList.clear();
                    }
                    parentList.addFirst(node);
                } else if (costs.get(n) == newCost) {
                    LinkedList<String> parentList = parents.get(n);
                    if (parentList == null) {
                        parentList = new LinkedList<>();
                        parents.put(n, parentList);
                    }
                    parentList.addFirst(node);
                }
            }

            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }

        return getPath(parents);
    }

    private static LinkedList<String> getPath(Map<String, LinkedList<String>> parents) {
        LinkedList<String> path = new LinkedList<>();
        String node = "final";

        while (!node.equals("start")) {
            path.addFirst(node);
            node = parents.get(node).getFirst();
        }

        path.addFirst("start");
        return path;
    }

    private static String findLowestCostNode(Map<String, Integer> costs, Set<String> processed) {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for (String node : costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }


    private static void putValuesInParents(Map<String, LinkedList<String>> parents) {
        parents.put("A", new LinkedList<>());
        parents.put("B", new LinkedList<>());
        parents.put("in", new LinkedList<>());
        parents.get("A").addFirst("start");
        parents.get("B").addFirst("start");
    }

    private static void putValuesInCosts(Map<String, Integer> costs) {
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("final", Integer.MAX_VALUE);
    }

    private static void putValuesInGraph(Map<String, Map<String, Integer>> graph) {
        graph.put("start", new HashMap<>());
        graph.put("A", new HashMap<>());
        graph.put("B", new HashMap<>());
        graph.put("final", new HashMap<>());

        graph.get("start").put("A", 6);
        graph.get("start").put("B", 2);

        graph.get("A").put("final", 1);

        graph.get("B").put("A", 3);
        graph.get("B").put("final", 5);
    }
}
