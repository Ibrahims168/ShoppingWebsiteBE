package com.shoppingWebsite.controller;

import com.shoppingWebsite.model.CustomItem;
import com.shoppingWebsite.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping("/create")
    @CrossOrigin
    public Long createItem(@RequestBody CustomItem customItem){
        return itemService.createItem(customItem);
    }
    @GetMapping("/get/{id}")
    public CustomItem getItemById(@PathVariable Long id){
         return itemService.getItemById(id);
    }
}
