package org.skypro.skyshop.basket;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import org.skypro.skyshop.product.Product;
import java.util.Collection;

public class ProductBasket {
    private final Map<String, List<Product>> massiveProduct  = new HashMap<>();
    private int count = 0;

    public void newProduct(Product product) {
        massiveProduct.computeIfAbsent(product.getNameProduct(), k -> new LinkedList<Product>()).add(product);
        count++;
    }

    public int sumProduct() {
        return massiveProduct.values().stream().flatMap(Collection::stream)
                .mapToInt(Product :: getPrice)
                .sum();
    }

    public void sealProduct() {
        if (massiveProduct.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        massiveProduct.values().stream().flatMap(Collection::stream)
                        .forEach(System.out::println);


        System.out.println("Итого: " + sumProduct());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean sameName(String name) {
        return massiveProduct.containsKey(name);
    }

    public void cleaningMassive() {
        massiveProduct.clear();
    }

    private long getSpecialCount() {
        return massiveProduct.values().stream().flatMap(Collection::stream)
                .filter(product -> product.isSpecial())
                .count();

    }

    public List <Product> removeProductByName(String name) {
        List<Product> massiveProduct2 = massiveProduct.remove(name);
        if (massiveProduct2 == null) {
            return new LinkedList<Product>();
        }
        return massiveProduct2;
    }
}






