package jpashop.web;

import jpashop.domain.item.Book;
import jpashop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by yongjunjung on 2016. 10. 12..
 */

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/items/new", method = GET)
    public String newItem() {
        return "items/createItemForm";
    }

    @RequestMapping(value = "/items/new", method = POST)
    public String newItem(Book item) {
        itemService.save(item);
        return "redirect:/items";
    }
}
