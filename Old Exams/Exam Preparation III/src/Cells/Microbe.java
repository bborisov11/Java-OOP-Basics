package Cells;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return virulence;
    }

    public void setVirulence(int virulence) {
        this.virulence = virulence;
    }

    @Override
    public String toString() {
        StringBuilder microbe = new StringBuilder();
        microbe.append(super.toString()).append("--------Health: ").append(this.getHealth()).append(" | Virulence: ")
        .append(this.virulence).append(" | Energy: ").append(this.calculateEnergy()).append(System.lineSeparator());
        return microbe.toString();
    }
}
