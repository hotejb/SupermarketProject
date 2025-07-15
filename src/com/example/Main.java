
package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 超市项目主类，用于演示和验证所有功能
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("====== 面向对象的超市计价系统 (BigDecimal版本) ======");

        // 初始化收银台
        Cashier cashier = new Cashier();

        // --- 1. 顾客 A 的场景 ---
        System.out.println("\n--- 场景1：顾客A购买苹果和草莓 ---");
        List<CartItem> cartA = new ArrayList<>();
        cartA.add(new CartItem("苹果", 8.0, 5));
        cartA.add(new CartItem("草莓", 13.0, 2));
        BigDecimal totalA = cashier.calculateTotalPrice(cartA, null);
        BigDecimal expectedA = BigDecimal.valueOf(5 * 8.0 + 2 * 13.0);
        System.out.println("顾客A的购物清单: " + cartA);
        System.out.printf("计算出的总价: %.2f\n", totalA);
        System.out.printf("期望的总价: %.2f\n", expectedA);
        System.out.println("结果验证: " + (totalA.compareTo(expectedA) == 0 ? "正确" : "错误"));

        // --- 2. 顾客 B 的场景 ---
        System.out.println("\n--- 场景2：顾客B购买苹果、草莓和芒果 ---");
        List<CartItem> cartB = new ArrayList<>();
        cartB.add(new CartItem("苹果", 8.0, 3));
        cartB.add(new CartItem("草莓", 13.0, 4));
        cartB.add(new CartItem("芒果", 20.0, 2));
        BigDecimal totalB = cashier.calculateTotalPrice(cartB, null);
        BigDecimal expectedB = BigDecimal.valueOf(3 * 8.0 + 4 * 13.0 + 2 * 20.0);
        System.out.println("顾客B的购物清单: " + cartB);
        System.out.printf("计算出的总价: %.2f\n", totalB);
        System.out.printf("期望的总价: %.2f\n", expectedB);
        System.out.println("结果验证: " + (totalB.compareTo(expectedB) == 0 ? "正确" : "错误"));

        // --- 3. 顾客 C 的场景 (草莓打8折) ---
        System.out.println("\n--- 场景3：顾客C购买，草莓打8折 ---");
        List<CartItem> cartC = new ArrayList<>();
        cartC.add(new CartItem("苹果", 8.0, 2));
        cartC.add(new CartItem("草莓", 13.0, 5));
        cartC.add(new CartItem("芒果", 20.0, 1));
        PromotionStrategy strategyC = new StrawberryDiscountStrategy(0.8);
        BigDecimal totalC = cashier.calculateTotalPrice(cartC, strategyC);
        BigDecimal expectedC = BigDecimal.valueOf(2 * 8.0 + 5 * (13.0 * 0.8) + 1 * 20.0);
        System.out.println("顾客C的购物清单: " + cartC);
        System.out.println("促销活动: 草莓打8折");
        System.out.printf("计算出的总价: %.2f\n", totalC);
        System.out.printf("期望的总价: %.2f\n", expectedC);
        System.out.println("结果验证: " + (totalC.compareTo(expectedC) == 0 ? "正确" : "错误"));

        // --- 4. 顾客 D 的场景 (草莓打8折 + 满100减10) ---
        System.out.println("\n--- 场景4：顾客D购买，草莓打8折且满100减10 ---");
        List<CartItem> cartD = new ArrayList<>();
        cartD.add(new CartItem("苹果", 8.0, 10));
        cartD.add(new CartItem("草莓", 13.0, 3));
        cartD.add(new CartItem("芒果", 20.0, 1));
        PromotionStrategy strategyD = new FullReductionStrategy(
                new StrawberryDiscountStrategy(0.8),
                100.0,
                10.0
        );
        BigDecimal totalD = cashier.calculateTotalPrice(cartD, strategyD);
        BigDecimal subTotalD = BigDecimal.valueOf(10 * 8.0 + 3 * (13.0 * 0.8) + 1 * 20.0);
        BigDecimal expectedD = subTotalD.subtract(BigDecimal.valueOf(10.0));
        System.out.println("顾客D的购物清单: " + cartD);
        System.out.println("促销活动: 草莓打8折，且总价满100减10");
        System.out.printf("计算出的总价: %.2f\n", totalD);
        System.out.printf("期望的总价: %.2f\n", expectedD);
        System.out.println("结果验证: " + (totalD.compareTo(expectedD) == 0 ? "正确" : "错误"));
    }
}
