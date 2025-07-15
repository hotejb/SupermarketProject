package com.example;

import java.math.BigDecimal;
import java.util.List;

/**
 * 满减策略 (Decorator Pattern)
 * 这个策略可以包装另一个策略，实现策略的组合。
 */
class FullReductionStrategy implements PromotionStrategy {
    private final PromotionStrategy baseStrategy; // 基础策略，例如先打折
    private final BigDecimal threshold; // 满减的门槛，如 100
    private final BigDecimal reduction; // 减去的金额，如 10

    public FullReductionStrategy(PromotionStrategy baseStrategy, double threshold, double reduction) {
        // 如果没有基础策略，则默认为无折扣
        this.baseStrategy = (baseStrategy != null) ? baseStrategy : new NoDiscountStrategy();
        this.threshold = BigDecimal.valueOf(threshold);
        this.reduction = BigDecimal.valueOf(reduction);
    }

    @Override
    public BigDecimal apply(List<CartItem> items) {
        // 1. 首先，根据基础策略计算商品折扣后的总价
        BigDecimal subtotal = baseStrategy.apply(items);

        // 2. 然后，在此基础上应用满减
        if (subtotal.compareTo(threshold) >= 0) {
            return subtotal.subtract(reduction);
        } else {
            return subtotal;
        }
    }
}