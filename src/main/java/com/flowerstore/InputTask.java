package com.flowerstore;

import java.util.Scanner;

public class InputTask implements Runnable {
    private final Scanner scanner; // 사용자 입력을 받기 위한 Scanner 객체
    private final String prompt; // 사용자에게 입력을 요청하는 메시지
    private final int min; // 입력값의 최소 허용값
    private final int max; // 입력값의 최대 허용값
    private int result; // 사용자가 입력한 값을 저장하는 변수

    public InputTask(Scanner scanner, String prompt, int min, int max) {
        this.scanner = scanner; // Scanner 객체를 초기화
        this.prompt = prompt; // 입력 요청 메시지를 초기화
        this.min = min; // 최소 허용값을 초기화
        this.max = max; // 최대 허용값을 초기화
    }

    @Override
    public void run() {
        while (true) { // 유효한 입력이 들어올 때까지 반복
            System.out.println(prompt); // 입력 요청 메시지 출력
            try {
                int choice = scanner.nextInt(); // 사용자의 입력을 정수로 받음
                if (choice >= min && choice <= max) { // 입력값이 허용 범위 내에 있는지 확인
                    result = choice; // 입력값을 result에 저장
                    break; // 루프를 종료
                } else {
                    System.out.println("보기에 있는 숫자를 선택해주세요"); // 잘못된 입력일 경우 메시지 출력
                }
            } catch (Exception e) { // 예외가 발생한 경우 (예: 숫자가 아닌 값 입력)
                System.out.println("보기에 있는 숫자를 선택해주세요"); // 잘못된 입력 메시지 출력
                scanner.next(); // 잘못된 입력을 소비하여 무한 루프를 방지
            }
        }
    }

    public int getResult() {
        return result; // 입력된 값을 반환
    }
}
