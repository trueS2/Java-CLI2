package com.flowerstore.model; // 패키지 선언

/**
 * Packaging 클래스는 Product 클래스를 상속받으며,
 * 추가 포장 옵션을 나타내는 클래스
 */
public class Packaging extends Product {
    private boolean isAdditionalPackaging; // 추가 포장 여부를 저장하는 속성
    private String packagingOption; // 포장 옵션을 저장하는 속성 (예: 편지지, 꽃말 카드)

    // 생성자: Packaging 객체를 초기화해
    public Packaging(String type, boolean isAdditionalPackaging, String packagingOption) {
        super(type); // 부모 클래스(Product)의 생성자를 호출해
        this.isAdditionalPackaging = isAdditionalPackaging; // 추가 포장 여부를 설정해
        this.packagingOption = packagingOption; // 포장 옵션을 설정해
    }

    // isAdditionalPackaging 속성을 반환해 (추가 포장 여부를 반환)
    public boolean isAdditionalPackaging() {
        return isAdditionalPackaging; // 추가 포장 여부를 반환해
    }

    // isAdditionalPackaging 속성을 설정해 (추가 포장 여부를 설정)
    public void setAdditionalPackaging(boolean additionalPackaging) {
        isAdditionalPackaging = additionalPackaging; // 추가 포장 여부를 설정해
    }

    // packagingOption 속성을 반환해 (포장 옵션을 반환)
    public String getPackagingOption() {
        return packagingOption; // 포장 옵션을 반환해
    }

    // packagingOption 속성을 설정해 (포장 옵션을 설정)
    public void setPackagingOption(String packagingOption) {
        this.packagingOption = packagingOption; // 포장 옵션을 설정해
    }

    // Packaging 객체의 문자열 표현을 반환해 (객체 정보를 문자열로 반환)
    @Override
    public String toString() {
        return "Packaging{" +
                "type='" + getType() + '\'' + // 상품 유형을 문자열로 반환
                ", isAdditionalPackaging=" + isAdditionalPackaging + // 추가 포장 여부를 문자열로 반환
                ", packagingOption='" + packagingOption + '\'' + // 포장 옵션을 문자열로 반환
                '}'; // Packaging 객체의 문자열 표현을 반환
    }
}
