package com.shoppingWebsite.service;

import com.shoppingWebsite.model.CustomItem;

public interface ItemService {
    Long createItem(CustomItem customItem);
    void updateItem(CustomItem customItem);
    void deleteItemById(Long id);
    CustomItem getItemById(Long id);
}
