package com.arichafamily.java;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void addPlayer() {
        int choice = IO.getInt("Which Player to add?\n" +
                "1)Offence Player\n" +
                "2)Defence Player", 1, 2);

        if (choice == 1)
            players.add(new OffencePlayer());
        else if (choice == 2)
            players.add(new DefencePlayer());
    }

    public void removePlayer(Player p){
        players.remove(p);
    }

    public void removePlayer(String name){
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name)) {
                players.remove(p);
                break;
            }
        }
    }

    public int shoot(){
        int playerCount = players.size();
        int randomPlayerIndex = RandomUtils.getInt(0, playerCount - 1);
        Player p = players.get(randomPlayerIndex);
        if (p instanceof DefencePlayer && p.shootFromTwo()) return 2;
        else if (p instanceof OffencePlayer && ((OffencePlayer) p).shootFromThree()) {
            return 3;
        }
        else return 0;
    }

    public void printPlayers(){
        System.out.println(players);
    }
}
