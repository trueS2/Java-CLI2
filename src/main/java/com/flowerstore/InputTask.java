package com.flowerstore;

import java.util.Scanner;

public class InputTask implements Runnable {
    private final Scanner scanner;
    private final String prompt;
    private final int min;
    private final int max;
    private int result;

    public InputTask(Scanner scanner, String prompt, int min, int max) {
        this.scanner = scanner;
        this.prompt = prompt;
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(prompt);
            try {
                int choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    result = choice;
                    break;
                } else {
                    System.out.println("보기에 있는 숫자를 선택해주세요");
                }
            } catch (Exception e) {
                System.out.println("보기에 있는 숫자를 선택해주세요");
                scanner.next(); // 잘못된 입력을 소비하여 무한 루프를 방지
            }
        }
    }

    public int getResult() {
        return result;
    }
}

