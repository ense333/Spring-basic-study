package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getIGrade() == Grade.VIP){  //enum은 "==" 를 통해 비교하는게 맞음
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
