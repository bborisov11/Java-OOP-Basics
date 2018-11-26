package Cells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    public int calculateEnergy() {
        return this.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        StringBuilder whiteBloodCell = new StringBuilder();
        whiteBloodCell.append(super.toString()).append(" | Velocity: ").append(this.velocity)
                .append(" | Energy: ").append(this.calculateEnergy()).append(System.lineSeparator());
        return whiteBloodCell.toString();
    }
}
