package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product fruit = new SimpleProduct("Яблоко", 323);
        Product fruit2 = new DiscountedProduct("Груша", 423,20);
        Product fruit3 = new FixPriceProduct("Виногдрад");


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