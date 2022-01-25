package com.basovProjects.cryptoCurrencyWatcher.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cryptocurrency {
    @Id
    private Long id;
    private String name;
    private Double cost;

    public Cryptocurrency() {
    }

    public Cryptocurrency(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Cryptocurrency(Long id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cryptocurrency that = (Cryptocurrency) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost);
    }

    @Override
    public String toString() {
        return "Cryptocurrency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
