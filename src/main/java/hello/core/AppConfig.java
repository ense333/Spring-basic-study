package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration    //설정정보에 작성
public class AppConfig {


    //그럼 여기서 싱글톤에 대해 생각을 해보자
    //@Bean memberService 를 부르면 memberRepository()를 호출하게 되고 이는 결국  new MemoryMemberRepository(); 를 부름
    //@Bean orderService의 경우도 위와 마찬가지로  new MemoryMemberRepository();를 부르게 되는데 이는 결국 singleton이 깨지는 것이
    //아닌가??

    @Bean   //각 메소드에 Bean 작성, 이렇게 되면 해당 메소드들 Spring 컨테이너에 등록됨
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    //이전에는 객체를 생성하고 할당해야 하는 구현체를 서비스 안에서 직접 했는데 이제는 AppConfig가 해줌
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(discountPolicy(), memberRepository());
        //return null;
    }



}
