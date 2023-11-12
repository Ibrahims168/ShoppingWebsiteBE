package com.shoppingWebsite.repository;

import com.shoppingWebsite.model.CustomItem;

public interface ItemRepository {
    Long createItem(CustomItem customItem);
    void updateItem(CustomItem customItem);
    void deleteItemById(Long id);
    CustomItem getItemById(Long id);
}
