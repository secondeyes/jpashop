package jpashop.repository;

import jpashop.domain.item.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by yongjunjung on 2016. 10. 12..
 */

@Repository
public class ItemRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);       //신규 영속성 컨텍스트에 저장한다.
        } else {
            em.merge(item);         //변경된 데이터를 저장한다.
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i",Item.class).getResultList();
    }
}
