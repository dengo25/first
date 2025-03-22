package vo;

import java.time.LocalDateTime;

public class ItemVO {

    private Integer id;
    private String name;
    private Integer price;
    private Integer discountPer;
    private LocalDateTime created;

    // 기본 생성자
    public ItemVO() {}


    public ItemVO(Integer id, String name, Integer price, Integer discountPer, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPer = discountPer;
        this.created = created;
    }

    // Getter and Setter methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(Integer discountPer) {
        this.discountPer = discountPer;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "ItemVO{" +
                "created=" + created +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discountPer=" + discountPer +
                '}';
    }
}
