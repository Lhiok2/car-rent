package com.car.rent.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author nayix
 * @date 2020/7/1 0:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("用户信息构造类")
public class UserDTO {
    @ApiModelProperty("用户id")
    private Long uid;

    @ApiModelProperty("用户名(2-16位英文字母及数字)")
    private String username;

    @ApiModelProperty("11位电话号码")
    private String tel;

    @JsonIgnore
    private String password;

    @ApiModelProperty("用户余额")
    private Integer balance;

    @ApiModelProperty("用户状态")
    private String identity;

    @ApiModelProperty("用户注册时间")
    private Date createTime;
}
