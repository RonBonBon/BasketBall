package com.arichafamily.java;

public class OffencePlayer extends Player {
    private int pctFromThree;

    @Override
    public String toString() {
        return "OffencePlayer{" +
                "pctFromThree=" + pctFromThree +
                "} " + super.toString();
    }

    public OffencePlayer() {
        super();
        this.pctFromThree = IO.getInt("Enter pct from 3:");
    }

    public OffencePlayer(String name, int pctFromTheField, int pctFromThree) {
        super(name, pctFromTheField);
        this.pctFromThree = pctFromThree;
    }

    public boolean shootFromThree() {
        int shoot = RandomUtils.getInt(0, 100);
        if (shoot <= pctFromThree) {
            score += 3; //protected accessible with inheritance
            System.out.println(this.name + " Scored from three!");
            return true;
        }
        System.out.println(this.name + " Failed from three...");
        return false;
    }
}
