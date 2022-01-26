package com.basovProjects.cryptoCurrencyWatcher.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "cryptocurrency")
public class Cryptocurrency {
    @Id
    private Long id;
    private String symbol;
    private Double price;


    public Cryptocurrency() {
    }

    public Cryptocurrency(String symbol, Double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public Cryptocurrency(Long id, String symbol, Double price) {
        this.id = id;
        this.symbol = symbol;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cryptocurrency that = (Cryptocurrency) o;
        return Objects.equals(id, that.id) && Objects.equals(symbol, that.symbol) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, price);
    }

    @Override
    public String toString() {
        return "Cryptocurrency{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
