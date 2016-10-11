package jpashop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yongjunjung on 2016. 10. 11..
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {

        return "home";
    }

    @ResponseBody
    @RequestMapping("/wait")
    public String wait(Model model) throws InterruptedException {

        Thread.sleep(1000);

        return "response";
    }

}

