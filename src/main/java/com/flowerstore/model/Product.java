package com.flowerstore.model;

/**
 * Product 클래스는 공통 속성을 가진 상위 클래스
 * 이 클래스는 type 속성을 포함하고 있으며, 모든 제품의 기본 정보를 관리
 */
public class Product {
    private String type; // 상품의 유형을 저장하는 속성

    // Product 객체를 초기화
    public Product(String type) {
        this.type = type; // 생성자에서 상품의 유형을 설정
    }

    // 상품의 유형을 반환
    public String getType() {
        return type; // 상품의 유형을 반환
    }

    // 상품의 유형을 설정
    public void setType(String type) {
        this.type = type; // 상품의 유형을 설정
    }

    // Product 객체의 문자열 반환
    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                '}'; // Product 객체의 문자열 표현을 반환
    }
}
