package com.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * 草莓打折策略
 */
class StrawberryDiscountStrategy implements PromotionStrategy {
    private final BigDecimal discountRate; // 例如 0.8 代表八折

    public StrawberryDiscountStrategy(double discountRate) {
        this.discountRate = BigDecimal.valueOf(discountRate);
    }

    @Override
    public BigDecimal apply(List<CartItem> items) {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : items) {
            if (Objects.equals(item.getFruitName(), "草莓")) {
                total = total.add(item.getSubtotal().multiply(discountRate));
            } else {
                total = total.add(item.getSubtotal());
            }
        }
        return total;
    }
}