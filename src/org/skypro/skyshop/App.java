package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import java.util.Arrays;

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

        SearchEngine product = new SearchEngine(5);
        product.add(fruit);
        product.add(fruit2);
        product.add(fruit3);

        Article article = new Article("Pop", "Текст артикула");
        Article article2 = new Article("Pop2", "Текст артикула2");
        product.add(article);
        product.add(article2);

        System.out.println(Arrays.toString(product.search("Яблоко")));
        System.out.println(Arrays.toString(product.search("Текст")));




    }
}