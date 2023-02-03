package co.com.sofka.challenge.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "buy_product")
public class BuyProduct {
    @EmbeddedId
    private BuyProductPK id;
    private Integer quantity;

    @ManyToOne
    @MapsId("idBuy")
    @JoinColumn(name = "id_buy", insertable = false, updatable = false)
    private Buy buy;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    public BuyProductPK getId() {
        return id;
    }

    public void setId(BuyProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
