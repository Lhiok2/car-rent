package com.car.rent.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserDTO {
    private Long uid;

    private String username;

    private String tel;

    @JsonIgnore
    private String password;

    private Integer balance;

    private String identity;

    private Date createTime;

    private Date lastEditTime;
}
