package com.car.rent.dto;

import com.car.rent.entity.Car;
import com.car.rent.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author nayix
 * @date 2020/7/1 0:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDTO {
    private Long billId;

    private User user;

    private Car cid;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer cost;

    private Integer billState;

    private Date startTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date endTime;
}
