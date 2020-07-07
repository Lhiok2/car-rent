package com.car.rent.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author nayix
 * @date 2020/7/7 21:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rent_license")
public class License {
    @Id
    @Column(length = 5)
    private Integer lid;

    @Column(length = 5, nullable = false, unique = true)
    private String brand;

    @Column(nullable = false)
    private String region;
}
