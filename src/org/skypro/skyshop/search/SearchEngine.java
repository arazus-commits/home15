package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

public class SearchEngine {
    private int count = 0;
    private Searchable[] size;
    public SearchEngine(int size) {
        this.size = new Searchable[size];
    }
    public Searchable[] search(String query) {
        Searchable[] massive = new Searchable[5];
        int foundCount = 0;
        for (int i = 0; i < this.size.length; i++) {
            if (this.size[i] != null && this.size[i].getSearchTerm().contains(query) == true && foundCount <= 5 ) {
                massive[foundCount] = this.size[i];
                foundCount++;
            }
            if (foundCount == 5){
                break;
            }
        }
        return massive;
    }

    public void add(Searchable searchable) {
        if (count < this.size.length) {
            for (int i = 0; i < this.size.length; i++) {
                if (this.size[i] == null) {
                    this.size[i] = searchable;
                    count++;
                    break;
                }
            }
        }
    }

}
