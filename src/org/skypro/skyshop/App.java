package org.skypro.skyshop;
import java.util.List;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product fruit = new SimpleProduct("Яблоко", 323);
        Product fruit2 = new DiscountedProduct("Груша", 423, 20);
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

        basket.sealProduct();

        System.out.println(basket.sameName("Яблоко"));

        System.out.println(basket.sumProduct());

        SearchEngine product = new SearchEngine();
        product.add(fruit);
        product.add(fruit2);
        product.add(fruit3);

        Article article = new Article("Pop", "Текст артикула");
        Article article2 = new Article("Pop2", "Текст артикула2");
        product.add(article);
        product.add(article2);

        System.out.println(product.search("Яблоко"));
        System.out.println(product.search("Текст"));

        try {
            Product fruit4 = new SimpleProduct("  ", 323);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product fruit5 = new SimpleProduct("Банан", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product fruit6 = new DiscountedProduct("Абрикос ", 320, 120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable result = product.searchable("Яблоко");
            System.out.println("Найден лучший результат");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            Searchable result2 = product.searchable("Космос");
            System.out.println("Найден лучший результат");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        List<Product> removed = basket.removeProductByName("Яблоко");
        System.out.println("Удаленные продукты: " + removed);
        basket.sealProduct();
        List<Product> removed2 = basket.removeProductByName("Апельсин");

        if (removed2.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket.sealProduct();





    }
}