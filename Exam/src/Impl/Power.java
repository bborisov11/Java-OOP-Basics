package Impl;

import interfaces.SuperPower;

public class Power implements SuperPower {
    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.name = name;
        this.powerPoints = powerPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.matches("@\\S+[_]*\\S*@") && name.length() > 5) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }
    }

    public double getPowerPoints() {
        return this.powerPoints + this.name.length() / 2;
    }

    public void setPowerPoints(double powerPoints) {
        if(powerPoints <= 0) {
            throw new IllegalArgumentException("Power points should be a possitive number!");
        }
        this.powerPoints = powerPoints;
    }
}
