package com.arichafamily.java;

public class DefencePlayer extends Player {
    private int numOfFouls = 0;

    //Constructors:
    public DefencePlayer() {
        super();
    }

    public DefencePlayer(String name, int pctFromTheLine) {
        super(name, pctFromTheLine);
    }

    public void doFoul(){
        numOfFouls++;
        System.out.println("Tackled");
    }

    @Override
    public String toString() {
        return "DefencePlayer{" +
                "numOfFouls=" + numOfFouls +
                "} " + super.toString();
    }
}
