package com.example;

import java.math.BigDecimal;
import java.util.List;

/**
 * 促销策略接口 (Strategy Pattern)
 * 定义了所有促销活动都必须具备的计算能力。
 */
interface PromotionStrategy {
    BigDecimal apply(List<CartItem> items);
}