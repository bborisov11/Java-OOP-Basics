package mordorsCrueltyPlan;

import java.util.HashMap;
import java.util.Map;

public class Gandalf {
    private int points;
    private final Map<String,Integer> foodsAndPoints = new HashMap<String,Integer>() {{
        put("cram",2);
        put("lembas",3);
        put("apple",1);
        put("melon",1);
        put("honeycake",5);
        put("mushrooms",-10);
    }};
    private String[] foods;

    public Gandalf(String[] foods) {
        this.setFoods(foods);
        this.points = 0;
    }

    public void setFoods(String[] foods) {
        this.foods = foods;
    }

    public int getPoints() {
        return points;
    }

    public int calculatingPoints() {

        for (String currentFood : this.foods) {

            if (this.foodsAndPoints.containsKey(currentFood)) {
                this.points += this.foodsAndPoints.get(currentFood);
            } else {
                if(currentFood.equals("")) {
                    continue;
                }
                this.points--;
            }
        }
        return this.points;
    }

    public String mood() {
        int currentPoints = this.points;

        if(currentPoints < -5) {
            return "Angry";
        }
        else if(currentPoints < 0) {
            return "Sad";
        }
        else if(currentPoints < 15) {
            return "Happy";
        }
        else {
            return "JavaScript";
        }

    }
}
