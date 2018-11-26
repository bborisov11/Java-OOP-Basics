package Organism;

import Cluster.Cluster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Organism {
    private String name;
    private Map<String,Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new HashMap<String, Cluster>();
    }

    public Map<String,Cluster> getClusters() {
        return clusters;
    }

    @Override
    public String toString() {
        StringBuilder organism = new StringBuilder();
        organism.append("Organism - ").append(this.name).append(System.lineSeparator())
                .append("--Clusters: ").append(this.clusters.size()).append(System.lineSeparator())
                .append("--Cells: ").append(this.clusters.entrySet()
                .stream().mapToInt(x -> x.getValue().getCells().size()).sum()).append(System.lineSeparator());
        for (Cluster cluster : clusters.values().stream().sorted(Comparator.comparing(x -> x.getId(),Comparator.reverseOrder())).collect(Collectors.toList())) {
            organism.append(cluster.toString());
        }

        return organism.toString();
    }
}
