package model;

public class Items {
    private String itemName;
    private String itemPrice;
    private String itemDescription;
    private int imageId;

    public Items(String itemName, String itemPrice, int imageId, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.imageId = imageId;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getimageId() {
        return imageId;
    }

    public void setimageId(int imageId) {
        this.imageId = imageId;
    }

}
