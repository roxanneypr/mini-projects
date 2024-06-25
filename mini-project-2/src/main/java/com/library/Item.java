package com.library;


public abstract class Item {
    private int itemId;
    private String title;

    // Item constuctor
    public Item(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        //this.itemId = nextItemId++;
        this.title = title;
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Item ID: " + itemId +
                ", Title: '" + title + '\'' +
                ", Type: '" + getType() + '\'';
    }
}
