package com.car.rent.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author nayix
 * @date 2020/6/28 19:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rent_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 13, updatable = false)
    private Long cid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    private License license;

    @Column(length = 20, nullable = false)
    private String number;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Long price;

    @Column(name = "create_time", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
