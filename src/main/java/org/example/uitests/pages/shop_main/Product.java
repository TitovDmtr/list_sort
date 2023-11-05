package org.example.uitests.pages.shop_main;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Comparator;

@Data                      //annotation for using "lombok". getters and setters will be generated automatically
@Accessors(chain = true)   //annotation: all methods that we use will end with "return this", it means that they will return the objects from this "Product" class
public class Product {
    private String name;
    private Double price;

    public static Comparator<Product> getComparatorForSorting(SortDirection sortDirection) {
        switch (sortDirection) {
            case PRICE_LOW_TO_HIGH:
                return new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice().compareTo(o2.getPrice());
                    }
                };
            case PRICE_HIGH_TO_LOW:
                return new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getPrice().compareTo(o1.getPrice());
                    }
                };
            case NAME_A_TO_Z:
                return new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                };
            case NAME_Z_TO_A:
                return new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getName().compareTo(o1.getName());
                    }
                };
        }
        return null;
    }

}
