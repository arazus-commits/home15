package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> size = new LinkedList<>();

    public Map <String, Searchable> search(String query) {
        Map <String, Searchable> massiveProduct = new TreeMap<>();
        for (Searchable searchable : size) {
            if (searchable.getSearchTerm().contains(query)) {
                massiveProduct.put(searchable.getName(), searchable);
            }
        }
        return massiveProduct;
    }


    public void add(Searchable searchable) {
        size.add(searchable);
    }

    public Searchable searchable(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxQuantity = 0;
        for (Searchable element : size) {
            int quantity = 0;
            int index = 0;
                int indexSubstrings = element.getSearchTerm().indexOf(search, index);
                while (indexSubstrings != -1) {
                    quantity++;
                    index = indexSubstrings + search.length();
                    indexSubstrings = element.getSearchTerm().indexOf(search, index);
                }

            if (quantity > maxQuantity) {
                bestMatch = element;
                maxQuantity = quantity;
            }

        }
        if (bestMatch == null) {
            throw new BestResultNotFound(search);

        }
        return bestMatch;

    }

}
