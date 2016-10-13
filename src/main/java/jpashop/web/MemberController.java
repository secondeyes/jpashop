package jpashop.web;

import jpashop.domain.Address;
import jpashop.domain.Member;
import jpashop.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2016. 10. 11..
 */

@Controller
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/members/new", method = GET)
    public String createForm() {
        return "members/createMemberForm";
    }

    @RequestMapping(value = "/members/new", method = POST)
    public String createForm(Member member, String city, String street, String zipcode) {

        Address address = new Address(city, street, zipcode);
        member.setAddress(address);

        memberService.join(member);

        return "redirect:/";
    }

    @RequestMapping(value = "members", method = GET)
    public String memberList(Model model) {

        logger.info("[START] memberList");

        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

}
