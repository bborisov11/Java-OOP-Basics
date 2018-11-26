package Cells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }
    public int calculateEnergy() {
        return (this.getHealth() + this.size) * 2;
    }

    @Override
    public String toString() {
        StringBuilder whiteBloodCell = new StringBuilder();
        whiteBloodCell.append(super.toString()).append(" | Size: ").append(this.size).append(" | Energy: ").append(this.calculateEnergy())
        .append(System.lineSeparator());
        return whiteBloodCell.toString();
    }
}
