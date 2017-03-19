package com.arichafamily.java;

import java.util.Timer;
import java.util.TimerTask;

public class StopTask extends TimerTask {

    private final Timer timer;

    StopTask(Timer t) {
        this.timer = t;
    }

    @Override
    public void run() {
        timer.cancel();
    }
}
