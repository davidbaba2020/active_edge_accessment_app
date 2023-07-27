package com.active_edge_accessment_app.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Objects;

// Stock.java
@Setter
@Getter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double currentPrice;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date lastUpdate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Stock stock = (Stock) o;
        return getId() != null && Objects.equals(getId(), stock.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


