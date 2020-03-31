package com.assure.movie.dto;

/**
 * @author Israel Yasis
 */
public class PriceDTO implements DTO {
    private Long id;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
