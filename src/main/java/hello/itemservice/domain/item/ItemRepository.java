package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 실무에서는 멀티 쓰레드 환경에서 HashMap을 사용하면 안된다 ConcurrentHashMap을 사용해야 한다.
    private static final Map<Long, Item> store = new HashMap<>();

    // 이것도 마찬가지로 동시성 문제가 생길 수 있기에 AtomicLong을 사용해야 한다.
    private static Long sequence = 0L;

    public Item save(Item item) {
        item.setId(sequence++);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // 정석대로라면 updateParam은 Item객체를 사용하면 안된다. 왜냐하면 id는 사용하지 않기 때문이다.
    // 따라서 updateItemParam 등의 객체를 새로 만들어서 사용하는 것이 원래는 좋다.
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    // 테스트용
    public void clearStore() {
        store.clear();
    }

}
