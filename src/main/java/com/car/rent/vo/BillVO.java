package com.car.rent.vo;

import com.car.rent.domain.Car;
import com.car.rent.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("账单信息构造类")
public class BillVO {
    @ApiModelProperty("账单id")
    private Long billId;

    @ApiModelProperty("账单关联用户")
    private User user;

    @ApiModelProperty("账单关联车辆")
    private Car car;

    @ApiModelProperty("账单价格")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long cost;

    @ApiModelProperty("账单状态")
    private String billState;

    @ApiModelProperty("交易起始时间")
    private Date startTime;

    @ApiModelProperty("交易结束时间")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date endTime;
}
