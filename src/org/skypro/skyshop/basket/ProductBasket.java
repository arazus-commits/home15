package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] massiveProduct = new Product[5];
    private int count = 0;

    public void newProduct(Product product) {
        if (count < 5) {
            for (int i = 0; i < massiveProduct.length; i++) {
                if (massiveProduct[i] == null) {
                    massiveProduct[i] = product;
                    count++;
                    break;
                }
            }
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int sumProduct() {
        int sum = 0;
        for (int i = 0; i < massiveProduct.length; i++) {
            if (massiveProduct[i] != null) {
                sum += massiveProduct[i].getPriceProduct();
            }
        }
        return sum;
    }

    public void sealProduct() {
        for (int i = 0; i < massiveProduct.length; i++) {
            if (massiveProduct[i] == null && i == 0) {
                System.out.println("В корзине пусто");
                break;
            } else if (massiveProduct[i] != null) {
                System.out.println(massiveProduct[i]);
            }
        }
        if (count > 0) {
            System.out.println("Итого:" + sumProduct());
        }
    }

    public boolean sameName(String name) {
        for (int i = 0; i < massiveProduct.length; i++) {
            if (massiveProduct[i] != null && massiveProduct[i].getNameProduct().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleaningMassive() {
        count = 0;
        for (int i = 0; i < massiveProduct.length; i++) {
massiveProduct[i] = null;
        }
    }
}






