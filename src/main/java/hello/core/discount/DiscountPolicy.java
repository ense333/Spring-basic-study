package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /*
    @return -> 할인 대상 금액을 가리킴(호출하고 나면 결과로 1000원이 나오면 즉 1000원이 할인 된것이라는 것을 나타냄
     */
    int discount(Member member, int price);
}
