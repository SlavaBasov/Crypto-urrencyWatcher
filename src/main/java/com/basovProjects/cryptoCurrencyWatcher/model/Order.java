package com.basovProjects.cryptoCurrencyWatcher.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saved_price")
    private double savedPrice;

    @ManyToOne
    private User user;

    @ManyToOne
    private Cryptocurrency cryptocurrency;

    public Order() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getSavedPrice() {
        return savedPrice;
    }

    public void setSavedPrice(Double savedPrice) {
        this.savedPrice = savedPrice;
    }
}
