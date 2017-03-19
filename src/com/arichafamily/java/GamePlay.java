package com.arichafamily.java;

import java.util.TimerTask;

import static java.lang.Thread.sleep;

class GamePlay {
        private Team mcb = new Team();
        private Team jru = new Team();
        private int mcbScore = 0;
        private int jruScore = 0;

    GamePlay() {
        //Creating Maccabi Fox Tel-Aviv Team
        mcb.addPlayer(new DefencePlayer("Yuval Zusman", 67));
        mcb.addPlayer(new DefencePlayer("Trevor Mbakwe", 56));
        mcb.addPlayer(new OffencePlayer("Guy Pnini", 49, 39));
        mcb.addPlayer(new OffencePlayer("Yogev Ohayon", 38, 35));
        mcb.addPlayer(new OffencePlayer("Taylor Rochestie", 44, 41));

        //Creating Hapoel Bank Yahav Jerusalem Team
        jru.addPlayer(new DefencePlayer("D'or Fischer", 69));
        jru.addPlayer(new DefencePlayer("Lior Eliyahu", 51));
        jru.addPlayer(new OffencePlayer("Yotam Halperin", 58,57));
        jru.addPlayer(new OffencePlayer("Bar Timor", 52,44));
        jru.addPlayer(new OffencePlayer("E. J. Rowland", 48,38));

        Runnable mcbShoot = new Runnable() {
            @Override
            public void run() {
                int mcbPoint = mcb.shoot();
                if (mcbPoint == 2) mcbScore += 2;
                else if (mcbPoint == 3) mcbScore += 3;
            }
        };

        Runnable jruShoot = new Runnable() {
            @Override
            public void run() {
                int jruPoint = jru.shoot();
                if (jruPoint == 2) jruScore += 2;
                else if (jruPoint == 3) jruScore += 3;
            }
        };

        Timer timer = new Timer();
        timer.scheduleNTimes(mcbShoot, 0, 60*1000, 20*2);
        timer.scheduleNTimes(jruShoot, 30*1000, 60*1000, 20*2);
    }

    public class Timer extends java.util.Timer {
        private int counter = 0;
        public void scheduleNTimes(Runnable r, long delay, long period, int numTimes) {
            TimerTask mTask = new TimerTask() {
                @Override
                public void run() {
                    r.run();
                    counter++;
                    if (counter >= numTimes) {
                        Timer.this.cancel();
                        System.out.println("\nGame Over!!!");
                        System.out.println("\nMaccabi Fox Tel-Aviv scored: " + mcbScore);
                        System.out.println("\nHapoel Bank Yahav Jerusalem scored: " + jruScore);
                        if (mcbScore > jruScore) System.out.println("\nMaccabi Wins");
                        else if (mcbScore < jruScore) System.out.println("\nHapoel Wins");
                        else System.out.println("\nIt's a Tie");
                    }
                }
            };
            scheduleAtFixedRate(mTask, delay, period);
        }
    }
}
