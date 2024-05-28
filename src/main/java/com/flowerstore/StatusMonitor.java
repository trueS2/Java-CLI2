package com.flowerstore;

import com.flowerstore.model.OrderStatus;

public class StatusMonitor implements Runnable {
    private final OrderStatus orderStatus;

    public StatusMonitor(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public void run() {
        while (true) {
            String status = orderStatus.getStatus();
            System.out.println("모니터링된 상태: " + status);
            if (status.equals("배송 완료")) {
                break; // 상태가 "배송 완료"가 되면 모니터링 종료
            }
        }
    }
}
