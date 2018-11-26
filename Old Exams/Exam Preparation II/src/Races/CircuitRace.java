package Races;

import Cars.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    public List<Car> getWinnerParticipants() {
        return super.getParticipants().stream()
                .sorted(Comparator.comparing(x -> (x.getHorsepower()/x.getAcceleration()) + (x.getSuspension() + x.getDurability())
                ,Comparator.reverseOrder())).limit(4).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder baseRace = new StringBuilder();
        baseRace.append(this.getRoute()).append(" - ").append(this.getLength() * this.laps).append(System.lineSeparator());

        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < this.laps; i++) {
            for (Car car : super.getParticipants()) {
                car.setDurability(car.getDurability() - this.getLength() * this.getLength());
            }
        }
        int counter = 1;
            Car firstCar = this.getWinnerParticipants().get(0);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,firstCar.getBrand()
                    ,firstCar.getModel()
                    ,((firstCar.getHorsepower()/firstCar.getAcceleration()) +
                            (firstCar.getSuspension() + firstCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.4))).append(System.lineSeparator());
            counter++;
            Car secondCar = this.getWinnerParticipants().get(1);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,secondCar.getBrand()
                    ,secondCar.getModel()
                    ,((secondCar.getHorsepower()/secondCar.getAcceleration()) +
                            (secondCar.getSuspension() + secondCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.3))).append(System.lineSeparator());
            counter++;
            Car thirdCar = this.getWinnerParticipants().get(2);
            winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                    ,thirdCar.getBrand()
                    ,thirdCar.getModel()
                    ,((thirdCar.getHorsepower()/thirdCar.getAcceleration()) +
                            (thirdCar.getSuspension() + thirdCar.getDurability()))
                    , (int)(this.getPrizePool() * 0.2))).append(System.lineSeparator());
            counter++;
        Car fourthCar = this.getWinnerParticipants().get(3);
        winners.append(counter).append(String.format(". %s %s %dPP - $%d"
                ,fourthCar.getBrand()
                ,fourthCar.getModel()
                ,((fourthCar.getHorsepower()/fourthCar.getAcceleration()) +
                        (fourthCar.getSuspension() + fourthCar.getDurability()))
                , (int)(this.getPrizePool() * 0.1)));

           return baseRace.append(winners).toString();
        }
}
