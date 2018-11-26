package Cars;

import Garage.Garage;
import Races.*;

import java.util.HashMap;
import java.util.Map;

public class CarManager {
   private Map<Integer,Car> registeredCars;
   private Map<Integer, Race> races;
   private Garage garage;

    public CarManager() {
        this.registeredCars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand,
                         String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        if (type.equals("Performance")) {
            this.registeredCars.putIfAbsent(id, new PerformanceCar(brand, model, year, (int)(horsepower* 1.5), acceleration, (int)(suspension* 0.75), durability));
    }
    else if(type.equals("Show")) {
            this.registeredCars.putIfAbsent(id, new ShowCar(brand, model, year, horsepower, acceleration, suspension, durability));
        }
    }
    public String check(int id) {
        if(this.registeredCars.containsKey(id)) {
            return this.registeredCars.get(id).toString();
        }
        return "Doesn't contain that id";
   }
   public void open(int id, String type, int length, String route, int prizePool) {
           switch (type) {
               case "Casual":
                   races.putIfAbsent(id,new CasualRace(length,route,prizePool));
                   break;
               case "Drag":
                   races.putIfAbsent(id, new DragRace(length,route,prizePool));
                   break;
               case "Drift":
                   races.putIfAbsent(id,new DriftRace(length,route,prizePool));
                   break;
           }
   }
    public void open(int id, String type, int length, String route, int prizePool, int parameter) {
        switch (type) {
            case "TimeLimit":
                races.putIfAbsent(id, new TimeLimitRace(length, route, prizePool, parameter));
                break;
            case "Circuit":
                races.putIfAbsent(id, new CircuitRace(length, route, prizePool, parameter));
                break;
        }
    }

   public void participate(int carId,int raceId) {
        if(!garage.getParkedCars().contains(this.registeredCars.get(carId))) {
            if(this.races.get(raceId) instanceof TimeLimitRace) {
                if(this.races.get(raceId).getParticipants().size() == 0) {
                    this.races.get(raceId).getParticipants().add(this.registeredCars.get(carId));
                }
            }
            else {
                this.races.get(raceId).getParticipants().add(this.registeredCars.get(carId));
            }
        }
   }
   public String start(int id) {
       if(this.races.get(id).getParticipants().size() != 0) {
           return this.races.remove(id).toString();
       }
       return "Cannot start the race with zero participants.";
   }
   public void park(int id) {
        if(this.races.values().stream().noneMatch(x -> x.getParticipants().contains(this.registeredCars.get(id)))) {
           this.garage.getParkedCars().add(this.registeredCars.get(id));
       }
   }
   public void unpark(int carId) {
        this.garage.getParkedCars().remove(this.registeredCars.get(carId));
   }

   public void tune(int tuneIndex, String addOn) {
        if(this.garage.getParkedCars().size() != 0) {
            for (Car car : garage.getParkedCars()) {
                car.setHorsepower(car.getHorsepower() + tuneIndex);
                car.setSuspension(car.getSuspension() + tuneIndex / 2);
                if (car instanceof PerformanceCar) {
                    ((PerformanceCar) car).getAddOns().add(addOn);
                } else {
                    ((ShowCar) car).setStars(((ShowCar) car).getStars() + tuneIndex);
                }
            }
        }
   }

}
