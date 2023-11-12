package com.shoppingWebsite.repository.mapper;

import com.shoppingWebsite.model.CustomItem;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ItemMapper implements RowMapper<CustomItem> {
    @Override
    public CustomItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomItem(
                rs.getLong("item_id"),
                rs.getString("item_title"),
                rs.getString("item_img"),
                rs.getLong("item_price"),
                rs.getLong("item_stock")
        );
    }
}