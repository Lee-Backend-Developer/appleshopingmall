package com.appleshopingmall.shop.cart;

import java.util.List;

public interface CartRepositoy {
    // 회원 번호로 장바구니 가지고 오기
    List<CartEntity> findMemberProductID(Long productID);

    // 회원 아이디로 장바구니 수량 가져옴
    int getMemberCartCount(Long memberID);

    // 회원번호로 장바구니에 담긴 총 금액
    int getCartTotalPrice(Long memberID);

    // 카트 아이디로 회원 번호 가지고 오기
    Long getMemberIDFindCardID(Long cardID);

    // 카트 아이디로 카트 삭제
    Long deleteCartID(Long cardID);
}