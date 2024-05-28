package com.flowerstore;

import com.flowerstore.model.OrderStatus;

public class StatusUpdater implements Runnable {
    private final OrderStatus orderStatus;

    public StatusUpdater(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            orderStatus.setStatus("주문 접수 완료");
            System.out.println("상태 업데이트: 주문 접수 완료");
            Thread.sleep(3000);
            orderStatus.setStatus("배송 준비 중");
            System.out.println("상태 업데이트: 배송 준비 중");
            Thread.sleep(3000);
            orderStatus.setStatus("배송 중");
            System.out.println("상태 업데이트: 배송 중");
            Thread.sleep(3000);
            orderStatus.setStatus("배송 완료");
            System.out.println("상태 업데이트: 배송 완료");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
