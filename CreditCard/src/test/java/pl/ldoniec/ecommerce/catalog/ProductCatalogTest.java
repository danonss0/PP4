package pl.ldoniec.ecommerce.catalog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.ldoniec.ecommerce.Product;
import pl.ldoniec.ecommerce.ProductCatalog;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class ProductCatalogTest {
    @Test
    void itListAvailableProducts(){
        ProductCatalog catalog = new ProductCatalog();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();
    }

    @Test
    void itAllowsToAddProduct(){
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct("Lego set 8083", "Nice one");

        List<Product> products = catalog.allProducts();

        Assertions.assertThat(products)
                .hasSize(1);
    }

    @Test
    void itLoadsSingleProductById(){
        ProductCatalog catalog = new ProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "Nice one");


        Product loaded = catalog.getProductById(id);
        assertThat(id).isEqualTo(loaded.getId());
    }

    @Test
    void itAllowsChangePrice(){
        ProductCatalog catalog = new ProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "Nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.getProductById(id);


        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loaded.getPrice());
    }
}
