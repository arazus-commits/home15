package org.skypro.skyshop.search;

public interface Searchable {
    String getName();
    String getSearchTerm();
    String getСontent();

    default String getStringRepresentation() {
        return getName() + " - " + getСontent();
    }
}
