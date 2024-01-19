package project.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.hello.repository.MemberRepository;
import project.hello.repository.MemoryMemberRepository;
import project.hello.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
