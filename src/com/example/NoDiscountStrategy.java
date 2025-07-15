package com.example;

import java.math.BigDecimal;
import java.util.List;

/**
 * 无折扣策略
 */
class NoDiscountStrategy implements PromotionStrategy {
    @Override
    public BigDecimal apply(List<CartItem> items) {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : items) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }
}