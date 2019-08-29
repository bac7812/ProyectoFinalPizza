package com.martin.proyectofinal;

import java.util.Date;

public class Pizza {
    private String objectId;
    private String place;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String icon;
    private String pizza;
    private String size;
    private String dough;
    private String drink;
    private String quantity;
    private String price;
    private String pay;
    private Date created;

    public Pizza() {
        objectId  = null;
        place = null;
        address = null;
        city = null;
        province = null;
        postalCode = null;
        icon = null;
        pizza = null;
        size = null;
        dough = null;
        drink = null;
        quantity = null;
        price = null;
        pay = null;
        created = null;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectID) {
        this.objectId = objectId;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
