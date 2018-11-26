package pizzaCalories;
import java.util.HashMap;
import java.util.Map;

public class Doughs {
    private String currentFlour;
    private String currentTechnique;
    private int weightInGrams;
    private final Map<String,Double> doughMainIng;
    private final Map<String,Double> additionalIng;

    public Doughs(String flour, String technique, int weightInGrams) {
        this.weightInGrams = weightInGrams;
        this.currentFlour = flour;
        this.currentTechnique = technique;
        this.doughMainIng = new HashMap<>();
        this.additionalIng = new HashMap<>();
        this.fillDoughMainIng();
        this.fillTech();
        this.containFlourAndTechnique();
        this.weightInGramsUnder200();
        }
        private void fillDoughMainIng() {
            doughMainIng.put("White",1.5);
            doughMainIng.put("Wholegrain",1.0);
        }
    private void fillTech() {
        this.additionalIng.put("Crispy",0.9);
        this.additionalIng.put("Chewy",1.1);
        this.additionalIng.put("Homemade",1.0);
    }

    private void containFlourAndTechnique() {
        if(!(this.doughMainIng.containsKey(this.currentFlour) && this.additionalIng.containsKey(this.currentTechnique))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
    private void weightInGramsUnder200() {
        double currentWeightInGrams = this.weightInGrams; //* this.doughMainIng.get(this.currentFlour) * this.additionalIng.get(this.currentTechnique);
        if(currentWeightInGrams <= 0 || currentWeightInGrams > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }
    public double calculatingDoughsCalories() {
        return this.weightInGrams * this.doughMainIng.get(this.currentFlour) * this.additionalIng.get(this.currentTechnique) * 2;
    }
}
