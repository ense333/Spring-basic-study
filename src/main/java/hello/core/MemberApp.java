package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //MemberService memberService = new MemberServiceImpl();
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();  //그럼 이제 memberService에는 MemberServiceImpl이 들어가 있음

        //스프링은 모든게 ApplicationContext로 시작, 컨테이너라고 생각하면 됨
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //어노테이션 기반 Config
        //이렇게 하면 AppConfig에 있는 환경설정 정보를 가지고 스프링이 Appconfig안에 있는 @Bean이 붙은 것들을 컨테이너 안에서 관리해줌

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);  //기본적으로 메서드 이름으로 등록이 되기 떄문에 이름으로 꺼내옴,   appConfig.memberService 처럼 직접 찾아오는 것이 아닌 컨테이너에서 찾아오게 됨

        Member member = new Member(1L, "member1", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("New member = " + member.getName());
        System.out.println("Find member = " + findMember.getName());
    }
}
