package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// @Data는 한꺼번에 제공하기 때문에 위험할 수 있다. 차라리 상황에 맞게 알맞은 어노테이션을 고르자.
@Getter @Setter @ToString
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
