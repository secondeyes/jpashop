package jpashop.service;

import jpashop.domain.item.Item;
import jpashop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yongjunjung on 2016. 10. 12..
 */

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);
    }
}
