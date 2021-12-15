package com.forma.inventory.ui.model;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Objects;

public class ProductTable {
    private Long id;
    private Label name;
    private Integer stockInSalon;
    private Integer stockToBuy;
    private Integer stockPerWeek;
    private Button minusStock;
    private Button resetStock;
    private Button editProduct;
    private Button deleteProduct;

    public ProductTable() {
    }

    public ProductTable(Long id, Label name, Integer stockInSalon, Integer stockToBuy, Integer stockPerWeek,
                        Button minusStock, Button resetStock, Button editProduct, Button deleteProduct) {
        this.id = id;
        this.name = name;
        this.stockInSalon = stockInSalon;
        this.stockToBuy = stockToBuy;
        this.stockPerWeek = stockPerWeek;
        this.minusStock = minusStock;
        this.resetStock = resetStock;
        this.editProduct = editProduct;
        this.deleteProduct = deleteProduct;
    }

    public ProductTable(Integer stockInSalon) {
        this.stockInSalon = stockInSalon;
    }

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id;}

    public Label getName() {
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public Integer getStockInSalon() {
        return stockInSalon;
    }

    public void setStockInSalon(Integer stockInSalon) {
        this.stockInSalon = stockInSalon;
    }

    public Integer getStockToBuy() {
        return stockToBuy;
    }

    public void setStockToBuy(Integer stockToBuy) {
        this.stockToBuy = stockToBuy;
    }

    public Integer getStockPerWeek() {
        return stockPerWeek;
    }

    public void setStockPerWeek(Integer stockPerWeek) {
        this.stockPerWeek = stockPerWeek;
    }

    public Button getMinusStock() { return minusStock;}

    public void setMinusStock(Button minusStock) { this.minusStock = minusStock;}

    public Button getResetStock() { return resetStock;}

    public void setResetStock(Button resetStock) { this.resetStock = resetStock;}

    public Button getEditProduct() {
        return editProduct;
    }

    public void setEditProduct(Button editProduct) {
        this.editProduct = editProduct;
    }

    public Button getDeleteProduct() {
        return deleteProduct;
    }

    public void setDeleteProduct(Button deleteProduct) {
        this.deleteProduct = deleteProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTable that = (ProductTable) o;
        return stockInSalon.equals(that.stockInSalon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stockInSalon, stockToBuy, stockPerWeek);
    }

    @Override
    public String toString() {
        return "ProductTable{" +
                "name='" + name.getText() + '\'' +
                ", stockInSalon=" + stockInSalon +
                ", stockToBuy=" + stockToBuy +
                ", stockPerWeek=" + stockPerWeek +
                '}';
    }
}
