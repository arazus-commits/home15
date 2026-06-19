package org.skypro.skyshop.basket;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final List<Product> massiveProduct = new LinkedList<>();
    private int count = 0;

    public void newProduct(Product product) {
        massiveProduct.add(product);
        count++;
    }

    public int sumProduct() {
        int sum = 0;
        for (Product product : massiveProduct) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void sealProduct() {
        if (massiveProduct.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : massiveProduct) {
            System.out.println(product);
        }

        System.out.println("Итого: " + sumProduct());
        System.out.println("Специальных товаров: " + sumSpecial());
    }

    public boolean sameName(String name) {
        for (Product product : massiveProduct) {
            if (product.getNameProduct().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleaningMassive() {
        massiveProduct.clear();
    }

    public int sumSpecial() {
        int sum = 0;
        for (Product product : massiveProduct) {
            if (product.isSpecial() == true) {
                sum += 1;
            }
        }
        return sum;
    }

    public List <Product> removeProductByName(String name) {
        List<Product> massiveProduct2 = new LinkedList<>();
            Iterator<Product> iterator = massiveProduct.iterator();

            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getNameProduct().equals(name)) {
                    massiveProduct2.add(product);
                    iterator.remove();
                }
            }
        return massiveProduct2;
    }
}






