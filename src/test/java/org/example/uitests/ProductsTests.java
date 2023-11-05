package org.example.uitests;

import org.example.uitests.pages.shop_main.Product;
import org.example.uitests.pages.shop_main.ProductPageShop;
import org.example.uitests.pages.shop_main.ProductsPerPage;
import org.example.uitests.pages.shop_main.SortDirection;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductsTests extends BaseTests {

    @BeforeClass
    public void BeforeClass() {
        goToPart("8-dresses");
    }

    @Test
    public void allProductTest() {
        List<Product> productList = new ProductPageShop().getProducts();
        Assert.assertEquals(productList.size(), 12);
    }

    @Test
    public void checkSortingTest() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        List<Product> productsAsIs = productPageShop.getProducts();

        List<Product> productsAfterSorting = productPageShop.sortBy(SortDirection.PRICE_LOW_TO_HIGH).getProducts();

        Collections.sort(productsAsIs, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }

    @Test
    public void checkSortingTestCustom() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        List<Product> productsAsIs = productPageShop.showPerPage(ProductsPerPage.SHOW_60).getProducts();

        List<Product> productsAfterSorting = productPageShop.showPerPage(ProductsPerPage.SHOW_60).sortBy(SortDirection.NAME_A_TO_Z).getProducts();
        Collections.sort(productsAsIs, Product.getComparatorForSorting(SortDirection.NAME_A_TO_Z));

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }
}
