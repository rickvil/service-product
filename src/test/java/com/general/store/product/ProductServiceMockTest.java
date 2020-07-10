package com.general.store.product;

import com.general.store.product.entity.Category;
import com.general.store.product.entity.Product;
import com.general.store.product.repository.ProductRepository;
import com.general.store.product.service.ProductService;
import com.general.store.product.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this );

        productService = new ProductServiceImpl(productRepository);

        Product product = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .status("CREATED")
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("12.5"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        Mockito.when(productRepository.save(product))
                .thenReturn(product);
    }

    @Test
    public void  whenValidGetId_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertEquals(found.getName(), "computer");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product product = productService.updateStock(1L, Double.parseDouble("8"));

        Assertions.assertEquals(product.getStock(), Double.parseDouble("13"));

    }
}
