package com.ecommerce.ProductService.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Map;

@Entity
@DiscriminatorValue("accessory")
public class Accessory extends Product {
    private String type;
    private String material;
    private boolean isUnisex;

    public Accessory() {
        super();
    }

    public static Accessory create(long merchantId, Map<String, Object> input) {
        Accessory accessory = new Accessory();
        accessory.setCommonAttributes(input, merchantId);
        accessory.setType((String) input.get("type"));
        accessory.setMaterial((String) input.get("material"));
        accessory.setUnisex((input.get("isUnisex") != null) ? (Boolean) input.get("isUnisex") : false);
        return accessory;
    }

    // Accessory-specific setters
    public void setDetails(String type, String material, boolean isUnisex) {
        this.type = type;
        this.material = material;
        this.isUnisex = isUnisex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isUnisex() {
        return isUnisex;
    }

    public void setUnisex(boolean unisex) {
        isUnisex = unisex;
    }
}