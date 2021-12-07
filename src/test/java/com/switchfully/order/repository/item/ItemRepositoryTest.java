package com.switchfully.order.repository.item;

import com.switchfully.order.domain.item.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {

    ItemRepository itemRepository;

    @BeforeEach
    void setup(){
        itemRepository = new ItemRepository();
    }

    @Test
    void givenAnExistingItemRepository_whenAddingTwoItems_thenRepositorySizeIsExistingRepositorySizePlusTwo(){
        // Given
        // When
        int originalRepositorySize = itemRepository.getAllItems().size();
        itemRepository.add(new Item("Item1", "Description2", 250, 5));
        itemRepository.add(new Item("Item2", "Description3", 250, 5));
        // Then
        Assertions.assertThat(itemRepository.getAllItems().size()).isEqualTo(originalRepositorySize + 2);
    }


}