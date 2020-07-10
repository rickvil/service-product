package com.general.store.product;

import com.general.store.product.entity.Category;
import com.general.store.product.entity.Product;
import com.general.store.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whebFindCategoy_thenReturnListProduct(){
        Product product = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date()).build();

        productRepository.save(product);

        List<Product> found = productRepository.findByCategory(product.getCategory());

        Assertions.assertEquals(found.size(), 3);
    }
}
