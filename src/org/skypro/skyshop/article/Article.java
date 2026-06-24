package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String nameАrticle;
    private final String textАrticle;
    public Article(String nameАrticle, String textАrticle) {
        this.nameАrticle = nameАrticle;
        this.textАrticle = textАrticle;
    }
    public String getNameАrticle() {
        return nameАrticle;
    }
    public String getTextАrticle() {
        return textАrticle;
    }

    @Override
    public String toString() {
        return getNameАrticle() +"\n" + getTextАrticle();
    }
    @Override
    public String getSearchTerm() {
        return getNameАrticle() + " - " + getTextАrticle();
    }
    @Override
    public String getСontent() {
        return "ARTICLE";
    }
    @Override
    public String getName() {
        return getNameАrticle();
    }
}
