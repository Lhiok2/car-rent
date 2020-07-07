package com.car.rent.service.impl;

import com.car.rent.domain.License;
import com.car.rent.repository.LicenseRepository;
import com.car.rent.service.LicenseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nayix
 * @date 2020/7/7 21:56
 */
@Service
public class LicenseServiceImpl implements LicenseService {
    @Resource
    private LicenseRepository licenseRepository;

    @Override
    public List<License> getLicenseList() {
        return licenseRepository.getAll();
    }
}
