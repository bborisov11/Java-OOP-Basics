package wildFarm.food;

public abstract class Food {
    private int qunatity;

    protected Food(int qunatity) {
        this.qunatity = qunatity;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }
}
