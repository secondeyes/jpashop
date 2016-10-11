package jpashop.service;

import jpashop.domain.Member;
import jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by yongjunjung on 2016. 10. 11..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {

        //1.Given
        Member member = new Member();
        member.setName("Jun");

        //2.When
        Long saveId = memberService.join(member);

        //3.Then
        assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test(expected = IllegalStateException.class)
    public void 회원가입중복() throws Exception {

        //1.Given
        Member member1 = new Member();
        member1.setName("Jun");

        Member member2 = new Member();
        member2.setName("Jun");

        //2.When
        memberService.join(member1);
        memberService.join(member2);

        //3.Then
        fail("예외발생");
    }

}