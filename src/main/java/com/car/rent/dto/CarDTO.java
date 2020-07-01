package com.car.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author nayix
 * @date 2020/7/1 13:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private Long cid;

    private String state;

    private Integer price;

    private Date createTime;
}
