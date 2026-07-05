package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;
import java.util.stream.Collectors;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> size = new HashSet<>();

    public Set <Searchable> search(String query) {
   Set<Searchable> result = size.stream()
           .filter(searchable -> searchable.getSearchTerm().contains(query))
           .collect(Collectors.toCollection(() -> new TreeSet<>((s1, s2) -> {
               int o1 = s1.getName().length();
               int o2 = s2.getName().length();
               if (Integer.compare(o2, o1) == 0) {
                   return s1.getName().compareTo(s2.getName());
               } else {
                   return Integer.compare(o2, o1);
               }
           })));
        return result;
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



