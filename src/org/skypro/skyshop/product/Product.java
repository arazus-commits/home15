package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return this.nameProduct;
    }
    public abstract boolean isSpecial();

    @Override
   public String getSearchTerm() {
        return nameProduct;
    }
    @Override
    public String getСontent() {
        return "PRODUCT";
    }
    @Override
    public String getName() {
        return nameProduct;
    }

}