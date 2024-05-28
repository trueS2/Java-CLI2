package com.flowerstore;

import com.flowerstore.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("안녕하세요! 트루 꽃가게에 오신걸 환영합니다😊");

        // 주문 상태 객체 생성
        OrderStatus orderStatus = new OrderStatus();

        // 상태 모니터링 스레드 시작
        StatusMonitor statusMonitor = new StatusMonitor(orderStatus);
        Thread monitorThread = new Thread(statusMonitor);
        monitorThread.start();

        // "주문 접수중" 상태 설정
        orderStatus.setStatus("주문 접수중");

        // 꽃 선택
        printCurrentTime(); // 현재 시간 출력
        InputTask flowerChoiceTask = new InputTask(scanner, "원하는 꽃을 골라주세요 (1: 🌹장미🌹, 2: 🌷튤립🌷, 3: 🌻해바라기🌻, 4: 🪻하이신스🪻): ", 1, 4);
        Thread flowerChoiceThread = new Thread(flowerChoiceTask);
        flowerChoiceThread.start();
        try {
            flowerChoiceThread.join(); // flowerChoiceThread가 끝날 때까지 기다림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int flowerChoice = flowerChoiceTask.getResult();
        String flowerType = getFlowerType(flowerChoice);

        // 다발 또는 송이 선택
        printCurrentTime(); // 현재 시간 출력
        InputTask bouquetChoiceTask = new InputTask(scanner, "다발이면 1, 송이면 2를 입력하세요: ", 1, 2);
        Thread bouquetChoiceThread = new Thread(bouquetChoiceTask);
        bouquetChoiceThread.start();
        try {
            bouquetChoiceThread.join(); // bouquetChoiceThread가 끝날 때까지 기다림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isBouquet = bouquetChoiceTask.getResult() == 1;

        // 수량 입력
        printCurrentTime(); // 현재 시간 출력
        InputTask quantityTask = new InputTask(scanner, "수량을 입력하세요: ", 1, Integer.MAX_VALUE);
        Thread quantityThread = new Thread(quantityTask);
        quantityThread.start();
        try {
            quantityThread.join(); // quantityThread가 끝날 때까지 기다림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int quantity = quantityTask.getResult();

        Flower flower = new Flower(flowerType, quantity, isBouquet);

        // 포장 타입 선택
        printCurrentTime(); // 현재 시간 출력
        InputTask packagingChoiceTask = new InputTask(scanner, "쇼핑백이면 1, 바구니면 2를 입력하세요: ", 1, 2);
        Thread packagingChoiceThread = new Thread(packagingChoiceTask);
        packagingChoiceThread.start();
        try {
            packagingChoiceThread.join(); // packagingChoiceThread가 끝날 때까지 기다림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String packagingType = packagingChoiceTask.getResult() == 1 ? "쇼핑백" : "바구니";

        // 포장 추가 여부
        printCurrentTime(); // 현재 시간 출력
        boolean isPackaged;
        while (true) {
            System.out.println("포장을 추가하시겠습니까? (Y/N): ");
            String decision = scanner.next();
            if (decision.equalsIgnoreCase("Y")) {
                isPackaged = true;
                break;
            } else if (decision.equalsIgnoreCase("N")) {
                isPackaged = false;
                break;
            } else {
                System.out.println("y, n 중에 선택해주세요");
            }
        }

        String packagingDetail = "";
        if (isPackaged) {
            // 포장 세부 사항 선택
            printCurrentTime(); // 현재 시간 출력
            InputTask packagingDetailTask = new InputTask(scanner, "편지지면 1, 꽃말 카드면 2를 입력하세요: ", 1, 2);
            Thread packagingDetailThread = new Thread(packagingDetailTask);
            packagingDetailThread.start();
            try {
                packagingDetailThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            packagingDetail = packagingDetailTask.getResult() == 1 ? "편지지" : "꽃말 카드";
        }

        // Order 객체를 생성
        Order order = new Order(flower, packagingType, isPackaged, packagingDetail);

        // 주문 정보 출력
        printCurrentTime(); // 현재 시간 출력
        System.out.println("트루 꽃가게를 이용해 주셔서 감사합니다! 🌸향기로운 하루 되세요🌸");
        System.out.println("주문 정보: " + order);

        // 상태 업데이트 스레드 시작
        StatusUpdater statusUpdater = new StatusUpdater(orderStatus);
        Thread updaterThread = new Thread(statusUpdater);
        updaterThread.start();

        // 상태 모니터링 스레드가 종료되기를 기다림
        try {
            updaterThread.join();
            monitorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("현재 시간: " + sdf.format(new Date()));
    }

    private static String getFlowerType(int flowerChoice) {
        return switch (flowerChoice) {
            case 1 -> "장미";
            case 2 -> "튤립";
            case 3 -> "해바라기";
            case 4 -> "하이신스";
            default -> throw new IllegalArgumentException("잘못된 선택입니다.");
        };
    }
}
