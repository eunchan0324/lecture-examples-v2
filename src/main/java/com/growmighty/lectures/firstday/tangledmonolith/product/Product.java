package com.growmighty.lectures.firstday.tangledmonolith.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * product가 sellerId를 가지고 있어야 하는 이유
     * 1. 기존 DB에서도 product가 seller를 joinColumn 해서 가지고 있었다.
     * 2. 생명주기 : product는 seller가 있어야 만들 수 있고, seller는 product가 없이도 만들 수 있다.
     * 3. product와 seller는 N:1 관계이기 때문에 만약 seller에 product가 있다면, seller 1개 조회에 N개만큼 조회해야 한다.
     */
    @Column(nullable = false)
    private Long sellerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Setter
    @Column(nullable = false)
    private Integer stockQuantity;

    @Lob
    private String description;

    public static Product create(Long sellerId, String name, BigDecimal price, Integer stockQuantity, String description) {
        Product product = new Product();
        product.sellerId = sellerId;
        product.name = name;
        product.price = price;
        product.stockQuantity = stockQuantity;
        product.description = description;
        return product;
    }
}
