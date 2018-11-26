package Cluster;

import Cells.Cell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<Cell>();
    }

    public String getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = new ArrayList<>();
    }


    @Override
    public String toString() {
        StringBuilder cluster = new StringBuilder();
        cluster.append("----Cluster ").append(this.id).append(System.lineSeparator());
        for (Cell cell : cells.stream().sorted(Comparator.comparingDouble(
                Cell::getPositionRow).thenComparing(Cell::getPositionCol)).collect(Collectors.toList())) {
            cluster.append(cell.toString());
        }
        return cluster.toString();
    }
}
