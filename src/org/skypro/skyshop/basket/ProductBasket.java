package org.skypro.skyshop.basket;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Map<String, List<Product>> massiveProduct  = new HashMap<>();
    private int count = 0;

    public void newProduct(Product product) {
        massiveProduct.computeIfAbsent(product.getNameProduct(), k -> new LinkedList<Product>()).add(product);
        count++;
    }

    public int sumProduct() {
        int sum = 0;
        for (List<Product> productList : massiveProduct.values()) {
            for (Product product : productList) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void sealProduct() {
        if (massiveProduct.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (List<Product> productList : massiveProduct.values()) {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + sumProduct());
        System.out.println("Специальных товаров: " + sumSpecial());
    }

    public boolean sameName(String name) {
        return massiveProduct.containsKey(name);
    }

    public void cleaningMassive() {
        massiveProduct.clear();
    }

    public int sumSpecial() {
        int sum = 0;
        for (List<Product> productList : massiveProduct.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public List <Product> removeProductByName(String name) {
        List<Product> massiveProduct2 = massiveProduct.remove(name);
        if (massiveProduct2 == null) {
            return new LinkedList<Product>();
        }
        return massiveProduct2;
    }
}






