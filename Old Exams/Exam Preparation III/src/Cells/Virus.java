package Cells;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    public int calculateEnergy() {
        return this.getHealth() + this.getVirulence();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
