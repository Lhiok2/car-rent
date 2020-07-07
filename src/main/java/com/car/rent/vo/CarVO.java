package com.car.rent.vo;

import com.car.rent.domain.License;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @author nayix
 * @date 2020/7/1 13:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("车辆信息构造类")
public class CarVO {
    @ApiModelProperty("车辆id")
    private Long cid;

    @ApiModelProperty("车牌区号信息")
    private License license;

    @ApiModelProperty("车牌号")
    private String number;

    @ApiModelProperty("车辆状态")
    private String state;

    @ApiModelProperty("车辆基础价格")
    private Integer price;

    @ApiModelProperty("车辆注册时间")
    private Date createTime;
}
