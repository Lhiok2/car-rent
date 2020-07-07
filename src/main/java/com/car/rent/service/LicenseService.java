package com.car.rent.service;

import com.car.rent.domain.License;

import java.util.List;

/**
 * @author nayix
 * @date 2020/7/7 21:54
 */
public interface LicenseService {
    /**
     * 获取区号信息列表
     * @return
     */
    List<License> getLicenseList();
}
