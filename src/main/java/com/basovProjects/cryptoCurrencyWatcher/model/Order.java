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

    private String username;

    @ManyToOne
    private Cryptocurrency cryptocurrency;

    public Order() {
    }

    public Order(double savedPrice) {
        this.savedPrice = savedPrice;
    }

    public Order(double savedPrice, String username) {
        this.savedPrice = savedPrice;
        this.username = username;
    }

    public Order(double savedPrice, String username, Cryptocurrency cryptocurrency) {
        this.savedPrice = savedPrice;
        this.username = username;
        this.cryptocurrency = cryptocurrency;
    }

    public Order(Long id, double savedPrice, String username, Cryptocurrency cryptocurrency) {
        this.id = id;
        this.savedPrice = savedPrice;
        this.username = username;
        this.cryptocurrency = cryptocurrency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSavedPrice() {
        return savedPrice;
    }

    public void setSavedPrice(double savedPrice) {
        this.savedPrice = savedPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cryptocurrency getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(Cryptocurrency cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.savedPrice, savedPrice) == 0 && Objects.equals(id, order.id) && Objects.equals(username, order.username) && Objects.equals(cryptocurrency, order.cryptocurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, savedPrice, username, cryptocurrency);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", savedPrice=" + savedPrice +
                ", username='" + username + '\'' +
                ", cryptocurrency=" + cryptocurrency +
                '}';
    }
}
