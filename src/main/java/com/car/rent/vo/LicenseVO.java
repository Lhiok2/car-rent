package com.car.rent.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author nayix
 * @date 2020/7/7 21:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("车牌区号构造类")
public class LicenseVO {
    @ApiModelProperty("区域id")
    private Integer licenseId;

    @ApiModelProperty("区域编号")
    private String brand;

    @ApiModelProperty("区域信息")
    private String region;
}
