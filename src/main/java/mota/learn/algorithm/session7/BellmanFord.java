package mota.learn.algorithm.session7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

    private static List<Edge> edgeList = new ArrayList<>();
    private static Map<String, Integer> vertices = new HashMap<>();

    public static void main(String[] args) {
        init();

        for (int i = 0; i < vertices.size() - 1; i++){
            System.out.println("************ step : " + (i + 1));
            relax();
        }

        System.out.println("************ last step");

        if (relax()){
            System.out.println("a negative cycle detected!");
        }

        for (String key : vertices.keySet()) {
            System.out.println(key + " : " + vertices.get(key));
        }
    }

    private static boolean relax(){
        boolean update = false;
        for (Edge edge : edgeList) {
            if (vertices.get(edge.u) + edge.w < vertices.get(edge.v)){
                update = true;
                System.out.print(edge.u + "-->" + edge.v + " | ");
                System.out.println("new:" + (vertices.get(edge.u) + edge.w) + " - " + "old:" + vertices.get(edge.v));
                vertices.put(edge.v, vertices.get(edge.u) + edge.w);
            }
        }
        return update;
    }

    private static void init(){
        edgeList.add(new Edge("a", "b", 6));
        edgeList.add(new Edge("a", "c", 5));
        edgeList.add(new Edge("a", "d", 5));
        edgeList.add(new Edge("b", "e", -1));
        edgeList.add(new Edge("c", "b", -2));
        edgeList.add(new Edge("c", "e", 1));
        edgeList.add(new Edge("d", "c", -2));
        edgeList.add(new Edge("d", "f", -1));
        edgeList.add(new Edge("e", "g", 3));
        edgeList.add(new Edge("f", "g", 3));

        vertices.put("a", 0);
        vertices.put("b", Integer.MAX_VALUE);
        vertices.put("c", Integer.MAX_VALUE);
        vertices.put("d", Integer.MAX_VALUE);
        vertices.put("e", Integer.MAX_VALUE);
        vertices.put("f", Integer.MAX_VALUE);
        vertices.put("g", Integer.MAX_VALUE);
    }

    private static void init2(){
        edgeList.add(new Edge("a", "b", 5));
        edgeList.add(new Edge("b", "c", 1));
        edgeList.add(new Edge("b", "d", 2));
        edgeList.add(new Edge("c", "e", 1));
        edgeList.add(new Edge("d", "f", 2));
        edgeList.add(new Edge("e", "d", -1));
        edgeList.add(new Edge("f", "e", -3));

        vertices.put("a", 0);
        vertices.put("b", Integer.MAX_VALUE);
        vertices.put("c", Integer.MAX_VALUE);
        vertices.put("d", Integer.MAX_VALUE);
        vertices.put("e", Integer.MAX_VALUE);
        vertices.put("f", Integer.MAX_VALUE);
    }

    static class Edge {
        String u;
        String v;
        Integer w;

        public Edge(String u, String v, Integer w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
