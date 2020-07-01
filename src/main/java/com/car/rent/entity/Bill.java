package com.car.rent.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author nayix
 * @date 2020/6/30 15:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rent_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20, name = "bill_id", updatable = false)
    private Long billId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Car car;

    @Column(insertable = false)
    private Integer cost;

    @Column(name = "bill_state", nullable = false)
    private String billState;

    @Column(name = "start_time", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "end_time", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
}
