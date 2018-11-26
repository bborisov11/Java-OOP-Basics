import Cells.*;
import Cluster.Cluster;
import Organism.Organism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthManager {

    private Map<String, Organism> organisms = new HashMap<String, Organism>();

    public String checkCondition(String organismName) {
        if (organisms.containsKey(organismName)) {
            StringBuilder builder = new StringBuilder();
            builder.append(organisms.get(organismName));
            return builder.toString();
        }
        return "";
    }

    public String createOrganism(String name) {
        if (!organisms.containsKey(name)) {
            organisms.putIfAbsent(name, new Organism(name));
            return "Created organism " + name;
        } else {
            return "Organism " + name + " already exists";
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster cluster = new Cluster(id, rows, cols);
        if(this.organisms.containsKey(organismName)) {
            if (!this.organisms.get(organismName).getClusters().containsKey(id)) {
                this.organisms.get(organismName).getClusters().put(id, cluster);
                StringBuilder builder = new StringBuilder();
                builder.append("Organism ").append(organismName).append(": Created cluster ").append(id)
                .append(System.lineSeparator());
                return builder.toString();
            }
        }
        return "";
    }

    public String addCell(String organismName, String clusterId, String cellType,
                          String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        Cell currentCell = createCurrentCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);
        if(this.organisms.containsKey(organismName)) {
            if (this.organisms.get(organismName).getClusters().containsKey(clusterId)) {
                this.organisms.get(organismName).getClusters().get(clusterId).getCells().add(currentCell);
                StringBuilder builder = new StringBuilder();
                builder.append("Organism ").append(organismName).append(": Created cell ").append(cellId)
                        .append(" in cluster ").append(clusterId).append(System.lineSeparator());
                return builder.toString();
            }
        }
        return "";
    }

    public String activateCluster(String organismName) {
        String firstElement = "";
        if(this.organisms.size() == 0 || this.organisms.get(organismName).getClusters().size() == 0 ||
                !this.organisms.containsKey(organismName)) {
            return "";
        }

        for (String first : this.organisms.get(organismName).getClusters().keySet()) {
            firstElement = first;
            break;
        }
        Cluster currentCluster = this.organisms.get(organismName).getClusters().get(firstElement);

        int rows = currentCluster.getRows();
        int cols = currentCluster.getCols();
        Cell[][] matrix = new Cell[rows][cols];

        for (Cell cell : currentCluster.getCells()) {
            if(cell.getPositionRow() >= rows || cell.getPositionCol() >= cols) {
                continue;
            }
            matrix[cell.getPositionRow()][cell.getPositionCol()] = cell;
        }
        currentCluster.setCells(currentCluster.getCells());
        List<Cell> currentCells = currentCluster.getCells();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != null) {
                    currentCluster.getCells().add(matrix[row][col]);
                }
            }
        }
        Cell attackingCell = currentCells.get(0);
        List<Cell> cellsToRemove = new ArrayList<>();

            for (int i = 1; i < currentCells.size(); i++) {

                Cell secondCell = currentCells.get(i);

                if (currentCells.get(currentCells.size() - 1) != attackingCell) {
                    if (attackingCell instanceof BloodCell) {
                        attackingCell.setHealth(attackingCell.getHealth() + secondCell.getHealth());
                        attackingCell.setPositionRow(secondCell.getPositionRow());
                        attackingCell.setPositionCol(secondCell.getPositionCol());
                        cellsToRemove.add(secondCell);
                    } else if (attackingCell instanceof Microbe) {
                        while (true) {
                            secondCell.setHealth(secondCell.getHealth() - attackingCell.calculateEnergy());
                            if (secondCell.getHealth() <= 0) {
                                attackingCell.setPositionRow(secondCell.getPositionRow());
                                attackingCell.setPositionCol(secondCell.getPositionCol());
                                cellsToRemove.add(secondCell);
                                break;
                            }
                            attackingCell.setHealth(attackingCell.getHealth() - secondCell.calculateEnergy());
                            if (attackingCell.getHealth() <= 0) {
                                cellsToRemove.add(attackingCell);
                                attackingCell = secondCell;
                                break;
                            }
                        }
                    }
                }
            }

        currentCells.removeAll(cellsToRemove);
    //        this.organisms.get(organismName).getClusters().remove(currentCluster.getId());
    //    this.organisms.get(organismName).getClusters().put(currentCluster.getId(),currentCluster);
        return "Organism " + organismName + ": Activated cluster "+currentCluster.getId() +". Cells left: " + currentCells.size();
}

    private Cell createCurrentCell(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        switch (cellType) {
            case "WhiteBloodCell":
                return new WhiteBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
            case "RedBloodCell":
                return new RedBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
            case "Virus":
                return new Virus(cellId,health,positionRow,positionCol,additionalProperty);
            case "Bacteria":
                return new Bacteria(cellId,health,positionRow,positionCol,additionalProperty);
            case "Fungi":
                return new Fungi(cellId,health,positionRow,positionCol,additionalProperty);
        }
        return null;
    }
}
