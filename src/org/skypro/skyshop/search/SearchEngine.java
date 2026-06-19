package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> size = new LinkedList<>();


    public List <Searchable> search(String query) {
        List<Searchable> massiveProduct = new LinkedList<>();
        Iterator<Searchable> iterator = size.iterator();
        while (iterator.hasNext()) {
            Searchable searchable = iterator.next();
            if (searchable.getSearchTerm().contains(query)) {
                massiveProduct.add(searchable);
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
