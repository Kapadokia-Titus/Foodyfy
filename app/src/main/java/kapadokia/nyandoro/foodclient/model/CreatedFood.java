package kapadokia.nyandoro.foodclient.model;

import java.io.Serializable;

public class CreatedFood implements Serializable {

    String id;
    String createdName;
    String createdPrice;
    String createdQuantity;
    String createdDescription;
    String createdImageUrl;


    public  CreatedFood(){}

    public CreatedFood(String createdName, String createdPrice, String createdQuantity, String createdDescription, String createdImageUrl) {
        this.createdName = createdName;
        this.createdPrice = createdPrice;
        this.createdQuantity = createdQuantity;
        this.createdDescription = createdDescription;
        this.createdImageUrl = createdImageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getCreatedPrice() {
        return createdPrice;
    }

    public void setCreatedPrice(String createdPrice) {
        this.createdPrice = createdPrice;
    }

    public String getCreatedQuantity() {
        return createdQuantity;
    }

    public void setCreatedQuantity(String createdQuantity) {
        this.createdQuantity = createdQuantity;
    }

    public String getCreatedDescription() {
        return createdDescription;
    }

    public void setCreatedDescription(String createdDescription) {
        this.createdDescription = createdDescription;
    }

    public String getCreatedImageUrl() {
        return createdImageUrl;
    }

    public void setCreatedImageUrl(String createdImageUrl) {
        this.createdImageUrl = createdImageUrl;
    }

    @Override
    public String toString() {
        return "CreatedFood{" +
                "id='" + id + '\'' +
                ", createdName='" + createdName + '\'' +
                ", createdPrice='" + createdPrice + '\'' +
                ", createdQuantity='" + createdQuantity + '\'' +
                ", createdDescription='" + createdDescription + '\'' +
                ", createdImageUrl='" + createdImageUrl + '\'' +
                '}';
    }
}
