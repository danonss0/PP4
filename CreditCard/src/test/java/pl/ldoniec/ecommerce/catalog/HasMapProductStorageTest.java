package pl.ldoniec.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class HasMapProductStorageTest {

    public static final String TEST_PRODUCT_NAME = "test product";

    @Test
    void itStoreNewProduct(){
        ProductStorage storage = thereIsProductStorage();
        Product product = thereIsExampleProduct();

        storage.add(product);

        List<Product> products = storage.allProducts();
        assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains(TEST_PRODUCT_NAME);

    }

    private ProductStorage thereIsProductStorage() {
        return new HasMapProductStorage();
    }

    private Product thereIsExampleProduct(){
        return new Product(UUID.randomUUID(),TEST_PRODUCT_NAME,"dsda");
    }

    @Test
    void itLoadsAllProducts(){

    }

    @Test
    void itLoadsProductById(){

    }
}
