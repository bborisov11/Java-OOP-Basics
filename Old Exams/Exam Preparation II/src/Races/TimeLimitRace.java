package Races;

import Cars.Car;

import java.util.List;

public class TimeLimitRace extends Race {
    private int goldTime;
    private int currentPricePool;
    private int timePerformance;
    private String participantEarnedTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
        this.currentPricePool = prizePool;
    }

    @Override
    public List<Car> getWinnerParticipants() {
        int timePerformance = this.getLength() * (this.getParticipants().get(0).getHorsepower() / 100)
                * this.getParticipants().get(0).getAcceleration();
        this.timePerformance = timePerformance;
                if(timePerformance <= this.goldTime) {
                    this.participantEarnedTime = "Gold";
                }
        else if(timePerformance <= this.goldTime + 15) {
            this.currentPricePool = (int)(this.currentPricePool * 0.5);
                    this.participantEarnedTime = "Silver";
        }
        else if(timePerformance >= this.goldTime + 15) {
            this.currentPricePool = (int)(this.currentPricePool * 0.3);
                    this.participantEarnedTime = "Bronze";
        }
        return getParticipants();
    }

    @Override
    public String toString() {
        StringBuilder timeLimitRace = new StringBuilder();
        Car winnerCar = this.getWinnerParticipants().get(0);
        timeLimitRace.append(super.toString()).append(winnerCar.getBrand()).append(" ")
                .append(winnerCar.getModel()).append(" - ")
                .append(this.timePerformance).append(" s.").append(System.lineSeparator())
                .append(this.participantEarnedTime).append(" Time, $").append(this.currentPricePool).append(".");
        return timeLimitRace.toString();
    }
}
