package jpashop.web;

import jpashop.domain.Address;
import jpashop.domain.Member;
import jpashop.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yongjunjung on 2016. 10. 11..
 */

@Controller
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/member/register")
    @ResponseBody
    public String registerController() {

        System.out.println("register start!");

        Member member = new Member();
        Address address = new Address("CA", "DDD", "11111");

        member.setName("test");

        memberService.join(member);

        return "return";
    }
}
