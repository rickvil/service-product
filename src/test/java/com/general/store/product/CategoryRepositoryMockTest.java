package com.general.store.product;

import com.general.store.product.entity.Category;
import com.general.store.product.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CategoryRepositoryMockTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testInsertNewElement(){

        Category category = Category.builder()
                .name("uno nuevo")
                .build();

        categoryRepository.save(category);

        Assertions.assertEquals(categoryRepository.findAll().size(), 4);
    }
}
