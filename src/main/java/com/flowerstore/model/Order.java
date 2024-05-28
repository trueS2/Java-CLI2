package com.flowerstore.model; // 패키지 선언

/**
 * Order 클래스는 사용자의 주문 정보를 관리하는 클래스
 * 꽃, 포장 타입, 포장 추가 여부 및 추가 포장 옵션을 포함
 */
public class Order {
    private Flower flower; // 주문된 꽃을 저장하는 속성
    private String packagingType; // 포장 유형을 저장하는 속성
    private boolean isPackaged; // 포장 추가 여부를 저장하는 속성
    private String packagingDetail; // 포장 세부 사항을 저장하는 속성

    // 생성자: Order 객체를 초기화해
    public Order(Flower flower, String packagingType, boolean isPackaged, String packagingDetail) {
        this.flower = flower; // 주문된 꽃 객체를 설정해
        this.packagingType = packagingType; // 포장 유형을 설정해
        this.isPackaged = isPackaged; // 포장 추가 여부를 설정해
        this.packagingDetail = packagingDetail; // 포장 세부 사항을 설정해
    }

    // flower 속성을 반환해 (주문된 꽃 객체를 반환)
    public Flower getFlower() {
        return flower; // 주문된 꽃 객체를 반환해
    }

    // flower 속성을 설정해 (주문된 꽃 객체를 설정)
    public void setFlower(Flower flower) {
        this.flower = flower; // 주문된 꽃 객체를 설정해
    }

    // packagingType 속성을 반환해 (포장 유형을 반환)
    public String getPackagingType() {
        return packagingType; // 포장 유형을 반환해
    }

    // packagingType 속성을 설정해 (포장 유형을 설정)
    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType; // 포장 유형을 설정해
    }

    // isPackaged 속성을 반환해 (포장 추가 여부를 반환)
    public boolean isPackaged() {
        return isPackaged; // 포장 추가 여부를 반환해
    }

    // isPackaged 속성을 설정해 (포장 추가 여부를 설정)
    public void setPackaged(boolean packaged) {
        isPackaged = packaged; // 포장 추가 여부를 설정해
    }

    // packagingDetail 속성을 반환해 (포장 세부 사항을 반환)
    public String getPackagingDetail() {
        return packagingDetail; // 포장 세부 사항을 반환해
    }

    // packagingDetail 속성을 설정해 (포장 세부 사항을 설정)
    public void setPackagingDetail(String packagingDetail) {
        this.packagingDetail = packagingDetail; // 포장 세부 사항을 설정해
    }

    // Order 객체의 문자열 표현을 반환해 (객체 정보를 문자열로 반환)
    @Override
    public String toString() {
        return "Order{" +
                "flower=" + flower + // 주문된 꽃 객체의 정보를 문자열로 반환
                ", packagingType='" + packagingType + '\'' + // 포장 유형을 문자열로 반환
                ", isPackaged=" + isPackaged + // 포장 추가 여부를 문자열로 반환
                ", packagingDetail='" + packagingDetail + '\'' + // 포장 세부 사항을 문자열로 반환
                '}'; // Order 객체의 문자열 표현을 반환
    }
}
