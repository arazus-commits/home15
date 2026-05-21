package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product fruit = new Product("Яблоко", 323);
        Product fruit2 = new Product("Груша", 423);
        Product fruit3 = new Product("Виногдрад", 523);


        ProductBasket basket = new ProductBasket();
        basket.newProduct(fruit);
        basket.newProduct(fruit2);
        basket.newProduct(fruit3);
        basket.newProduct(fruit3);
        basket.newProduct(fruit3);
        basket.newProduct(fruit3);


        basket.sealProduct();

        System.out.println(basket.sumProduct());

        System.out.println(basket.sameName("Яблоко"));

        System.out.println(basket.sameName("Апельсин"));

        basket.cleaningMassive();

        basket.sealProduct();

        System.out.println(basket.sameName("Яблоко"));

        System.out.println(basket.sumProduct());


    }
}