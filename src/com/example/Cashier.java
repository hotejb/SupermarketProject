package com.example;

import java.math.BigDecimal;
import java.util.List;

/**
 * 收银台类：负责核心的计价逻辑
 */
class Cashier {
    /**
     * 核心计价方法
     * @param items 购物清单
     * @param strategy 使用的促销策略，可以为 null（无促销）
     * @return 最终价格
     */
    public BigDecimal calculateTotalPrice(List<CartItem> items, PromotionStrategy strategy) {
        if (strategy == null) {
            // 如果没有促销策略，使用默认的原价计算策略
            strategy = new NoDiscountStrategy();
        }
        return strategy.apply(items);
    }
}