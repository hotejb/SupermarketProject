package com.example;

import java.math.BigDecimal;

/**
 * 购物项：代表购买的一种水果及其重量
 */
class CartItem {
    private final String fruitName;
    private final BigDecimal pricePerJin;
    private final int weight; // 斤数，为整数

    public CartItem(String fruitName, double pricePerJin, int weight) {
        this.fruitName = fruitName;
        this.pricePerJin = BigDecimal.valueOf(pricePerJin);
        this.weight = weight;
    }

    public String getFruitName() {
        return fruitName;
    }

    public BigDecimal getPricePerJin() {
        return pricePerJin;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * 计算此项的小计金额，但不考虑促销
     */
    public BigDecimal getSubtotal() {
        return this.pricePerJin.multiply(BigDecimal.valueOf(this.weight));
    }
    
    @Override
    public String toString() {
        return String.format("%s (%.2f元/斤, %d斤)", fruitName, pricePerJin, weight);
    }
}