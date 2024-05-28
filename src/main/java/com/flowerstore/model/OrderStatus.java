package com.flowerstore.model;

public class OrderStatus {
    private String status; // 주문 상태를 저장하는 변수
    private boolean updated = false; // 상태가 업데이트 되었는지 여부를 나타내는 플래그

    public synchronized void setStatus(String status) {
        this.status = status;
        this.updated = true;
        notify(); // 상태가 변경되었음을 다른 스레드에 알림
    }

    public synchronized String getStatus() {
        while (!updated) {
            try {
                wait(); // 상태가 변경될 때까지 대기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.updated = false;
        return status;
    }
}
