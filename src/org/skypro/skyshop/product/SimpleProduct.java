package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
        if (price < 1) {
            throw new IllegalArgumentException(nameProduct + "Цена ниже 1");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getNameProduct() + " : " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

}
