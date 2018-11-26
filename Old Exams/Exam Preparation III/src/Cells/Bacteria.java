package Cells;

public class Bacteria extends Microbe{
    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    public int calculateEnergy() {
        return (this.getHealth() + this.getVirulence()) / 3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
