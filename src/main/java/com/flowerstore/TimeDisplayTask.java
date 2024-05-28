package com.flowerstore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDisplayTask implements Runnable {
    private boolean running = true; // 스레드 실행 상태를 저장하는 변수

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // 시간을 포맷하기 위한 SimpleDateFormat 객체
        while (running) { // running이 true인 동안 반복
            System.out.println("현재 시간: " + sdf.format(new Date())); // 현재 시간을 출력
            try {
                Thread.sleep(1000); // 1초마다 업데이트
            } catch (InterruptedException e) { // 스레드가 중단될 경우 예외 처리
                Thread.currentThread().interrupt(); // 현재 스레드에 인터럽트 신호 설정
                break; // 루프를 종료
            }
        }
    }

    // 스레드를 중지하기 위한 메서드
    public void stop() {
        running = false; // running을 false로 설정하여 루프를 종료
    }
}
