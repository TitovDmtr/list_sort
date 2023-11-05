package org.example.uitests.pages.shop_main;

public enum ProductsPerPage {
    SHOW_12("12"),
    SHOW_24("24"),
    SHOW_60("60");

    private String value;
    ProductsPerPage(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
