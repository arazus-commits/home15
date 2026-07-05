package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameАrticle, article.nameАrticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameАrticle);
    }
}
