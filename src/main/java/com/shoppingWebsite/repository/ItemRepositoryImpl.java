package com.shoppingWebsite.repository;

import com.shoppingWebsite.model.CustomItem;
import com.shoppingWebsite.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private static final String ITEM_TABLE_NAME = "item";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public Long createItem(CustomItem customItem) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (item_title, item_img, item_price, item_stock) values (?,?,?,?)";
        jdbcTemplate.update(
                sql,
                customItem.getItemTitle(),
                customItem.getItemImg(),
                customItem.getItemPrice(),
                customItem.getItemStock()
        );
        return jdbcTemplate.queryForObject("SELECT MAX(item_id) FROM " + ITEM_TABLE_NAME, Long.class);
    }

    @Override
    public void updateItem(CustomItem customItem) {

    }

    @Override
    public void deleteItemById(Long id) {

    }

    @Override
    public CustomItem getItemById(Long id) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE item_id=?";
        return jdbcTemplate.queryForObject(sql, new ItemMapper(), id);
    }
}
