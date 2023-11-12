package com.shoppingWebsite.model;

public class CustomItem {
    private Long itemId;
    private String itemTitle;
    private String itemImg;
    private Long itemPrice;
    private Long itemStock;
    public CustomItem(){};

    public CustomItem(Long itemId, String itemTitle, String itemImg, Long itemPrice, Long itemStock) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemImg = itemImg;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemImg() {
        return itemImg;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public Long getItemStock() {
        return itemStock;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemStock(Long itemStock) {
        this.itemStock = itemStock;
    }
}
