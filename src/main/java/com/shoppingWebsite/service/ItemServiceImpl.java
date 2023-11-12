package com.shoppingWebsite.service;

import com.shoppingWebsite.model.CustomItem;
import com.shoppingWebsite.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Long createItem(CustomItem customItem) {
        return itemRepository.createItem(customItem);
    }

    @Override
    public void updateItem(CustomItem customItem) {

    }

    @Override
    public void deleteItemById(Long id) {

    }

    @Override
    public CustomItem getItemById(Long id) {
        return itemRepository.getItemById(id);
    }
}
