package com.flowerstore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDisplayTask implements Runnable {
    private boolean running = true;

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        while (running) {
            System.out.println("현재 시간: " + sdf.format(new Date()));
            try {
                Thread.sleep(1000); // 1초마다 업데이트
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stop() {
        running = false;
    }
}
