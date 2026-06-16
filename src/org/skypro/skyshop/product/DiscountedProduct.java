package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;
    public DiscountedProduct (String nameProduct, int basePrice, int discount) {
        super (nameProduct);
        if (basePrice < 1) {
            throw new IllegalArgumentException(nameProduct + "Цена ниже 1");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(nameProduct + "Цена ушла за пределы %");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }
    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }
    @Override
    public String toString() {
        return getNameProduct() + " : " + getPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
