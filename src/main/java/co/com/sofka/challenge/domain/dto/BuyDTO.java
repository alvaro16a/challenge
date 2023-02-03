package co.com.sofka.challenge.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BuyDTO {
    private Integer idBuy;
    private LocalDateTime date;
    private String idType;
    private String clientName;
    private List<BuyProductDTO> products;

    public Integer getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(Integer idBuy) {
        this.idBuy = idBuy;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<BuyProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<BuyProductDTO> products) {
        this.products = products;
    }
}
