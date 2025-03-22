package vo;

import java.time.LocalDateTime;

public class OrderVO {
    private Integer id;
    private Integer memberId;
    private LocalDateTime created;
    private Integer totalPrice;
    private Integer quantity;

    public OrderVO() {
    }

    public OrderVO(LocalDateTime created, Integer id, Integer memberId, Integer quantity, Integer totalPrice) {
        this.created = created;
        this.id = id;
        this.memberId = memberId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
