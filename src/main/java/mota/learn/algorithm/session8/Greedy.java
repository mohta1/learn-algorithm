package mota.learn.algorithm.session8;

import org.apache.commons.collections4.SetUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Greedy {

    private static Set<String> statesNeeded;
    private static HashMap<String, Set<String>> stations;
    private static Set<String> finalStations;

    public static void main(String[] args) {

        initial();

        while (!statesNeeded.isEmpty()){
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();

            for (String station : stations.keySet()) {
                Set<String> states = stations.get(station);

                Set<String> covered = SetUtils.intersection(states, statesNeeded);

                if (covered.size() > statesCovered.size()){
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            statesNeeded = SetUtils.difference(statesNeeded, statesCovered);
            finalStations.add(bestStation);
        }

        System.out.println(finalStations);
    }

    private static void initial() {
        finalStations = new HashSet<>();

        statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        stations = new HashMap<>();
        stations.put("kOne", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("kTwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kThree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kFour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kFive", new HashSet<>(Arrays.asList("ca", "az")));
    }
}
