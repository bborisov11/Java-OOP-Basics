package Races;

import Cars.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public List<Car> getWinnerParticipants() {
        return super.getParticipants()
                .stream()
                .sorted(Comparator.comparing(x -> (x.getHorsepower()/x.getAcceleration()) + (x.getSuspension() + x.getDurability())
                ,Comparator.reverseOrder())).limit(3).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder winners = new StringBuilder();
        winners.append(super.toString());
        int counter = 1;
        if(this.getWinnerParticipants().size() >= 3) {
            Car firstCar = this.getWinnerParticipants().get(0);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,firstCar.getBrand()
                    ,firstCar.getModel()
                    ,((firstCar.getHorsepower()/firstCar.getAcceleration()) + (firstCar.getSuspension() + firstCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.5))).append(System.lineSeparator());
            counter++;
            Car secondCar = this.getWinnerParticipants().get(1);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,secondCar.getBrand()
                    ,secondCar.getModel()
                    ,((secondCar.getHorsepower()/secondCar.getAcceleration()) + (secondCar.getSuspension() + secondCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.3))).append(System.lineSeparator());
            counter++;
            Car thirdCar = this.getWinnerParticipants().get(2);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,thirdCar.getBrand()
                    ,thirdCar.getModel()
                    ,((thirdCar.getHorsepower()/thirdCar.getAcceleration()) + (thirdCar.getSuspension() + thirdCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.2)));

        }
        else if(this.getWinnerParticipants().size() == 2) {
            Car firstCar = this.getWinnerParticipants().get(0);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,firstCar.getBrand()
                    ,firstCar.getModel()
                    ,((firstCar.getHorsepower()/firstCar.getAcceleration()) + (firstCar.getSuspension() + firstCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.5))).append(System.lineSeparator());
            counter++;
            Car secondCar = this.getWinnerParticipants().get(1);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,secondCar.getBrand()
                    ,secondCar.getModel()
                    ,((secondCar.getHorsepower()/secondCar.getAcceleration()) + (secondCar.getSuspension() + secondCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.3)));
        }
        else {
            Car firstCar = this.getWinnerParticipants().get(0);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,firstCar.getBrand()
                    ,firstCar.getModel()
                    ,((firstCar.getHorsepower()/firstCar.getAcceleration()) + (firstCar.getSuspension() + firstCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.5)));
        }
        return winners.toString();
    }
}
