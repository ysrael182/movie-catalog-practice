package com.assure.movie.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Israel Yasis
 */
@Entity
@Table(name = "price")
public class Price implements Identifiable<Long> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "price",  updatable=false, precision = 12, scale=2)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
