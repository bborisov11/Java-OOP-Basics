package Cells;

public abstract class BloodCell extends Cell {

    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public String toString() {
        StringBuilder bloodCell = new StringBuilder();
        bloodCell.append(super.toString()).append("--------Health: ").append(this.getHealth());
        return bloodCell.toString();
    }
}
