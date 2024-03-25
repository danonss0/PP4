package pl.ldoniec.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        System.out.println("Here we go!!!");
        SpringApplication.run(App.class, args);
    }



    @Bean
    ProductCatalog createMyProductCatalog(){
        var catalog = new ProductCatalog();
        catalog.addProduct("Lego set1", "noice one");
        catalog.addProduct("Lego set2", "noice one");
        return catalog;
    }

}
