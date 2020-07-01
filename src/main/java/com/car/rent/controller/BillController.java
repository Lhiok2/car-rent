package com.car.rent.controller;

import com.car.rent.dto.BillDTO;
import com.car.rent.dto.CommonResult;
import com.car.rent.dto.UserDTO;
import com.car.rent.entity.User;
import com.car.rent.enums.constants.State;
import com.car.rent.enums.response.ResultCode;
import com.car.rent.service.BillService;
import com.car.rent.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.car.rent.utils.SessionUtils.getUserFromSession;

/**
 * @author nayix
 * @date 2020/7/1 23:35
 */
@RestController
@RequestMapping(value = "/api/v1/bills")
public class BillController {

    @Resource
    private BillService billService;

    @Resource
    private CarService carService;

    @PostMapping
    private CommonResult<?> addBill(@RequestParam Long cid, HttpServletRequest request) {
        UserDTO userDTO = getUserFromSession(request);
        if (userDTO == null) {
            return CommonResult.unauthorized();
        } else if (cid == null) {
            return CommonResult.notAcceptable();
        } else if (billService.getUnfinishedBill(userDTO.getUid()) != null) {
            return CommonResult.forbidden();
        } else if (State.isNormal(carService.getCarState(cid))) {
            return CommonResult.forbidden();
        }
        BillDTO billDTO = billService.addBill(userDTO.getUid(), cid);
        return CommonResult.success(billDTO, ResultCode.INTERNAL_ERROR);
    }

    @PutMapping
    private CommonResult<BillDTO> updateBill(@RequestParam Long cid, HttpServletRequest request) {
        UserDTO userDTO = getUserFromSession(request);
        if (userDTO == null) {
            return CommonResult.unauthorized();
        } else if (cid == null) {
            return CommonResult.notAcceptable();
        }
        BillDTO billDTO = billService.updateState(userDTO.getUid(), cid);
        return CommonResult.success(billDTO, ResultCode.FORBIDDEN);
    }

    @PutMapping("/pay")
    private CommonResult<?> payBill(@RequestParam Long billId) {
        // TODO 支付
        int code = billService.completePayment(billId);
        return CommonResult.getResultByCode(code);
    }

    @GetMapping("/unfinished")
    private CommonResult<BillDTO> getUnfinishedBill(HttpServletRequest request) {
        UserDTO userDTO = getUserFromSession(request);
        if (userDTO == null) {
            return CommonResult.unauthorized();
        }
        BillDTO billDTO = billService.getUnfinishedBill(userDTO.getUid());
        return CommonResult.success(billDTO);
    }
}
