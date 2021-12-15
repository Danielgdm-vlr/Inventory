package com.forma.inventory.backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")

public class Product extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "stockInSalon")
    private Integer stockInSalon;

    @Column(name = "stockPerWeek")
    private Integer stockPerWeek;

    public Product() {
    }

    public Product(String name, Integer stockInSalon, Integer stockPerWeek) {
        this.name = name;
        this.stockInSalon = stockInSalon;
        this.stockPerWeek = stockPerWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStockInSalon() {
        return stockInSalon;
    }

    public void setStockInSalon(Integer quantity) {
        this.stockInSalon = quantity;
    }

    public Integer getStockPerWeek() {
        return stockPerWeek;
    }

    public void setStockPerWeek(Integer defaultQuantityPerWeek) {
        this.stockPerWeek = defaultQuantityPerWeek;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", stockInSalon=" + stockInSalon +
                ", stockPerWeek=" + stockPerWeek +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(stockInSalon, product.stockInSalon) &&
                Objects.equals(stockPerWeek, product.stockPerWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stockInSalon, stockPerWeek);
    }
}