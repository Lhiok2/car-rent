package com.car.rent.controller;

import com.car.rent.dto.BillDTO;
import com.car.rent.dto.CommonResult;
import com.car.rent.service.BillService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.car.rent.utils.UserUtils.getUidFromSubject;
import static com.car.rent.utils.VerifyUtils.notNullVerify;

/**
 * @author nayix
 * @date 2020/7/1 23:35
 */
@Api("业务相关")
@RestController
@RequestMapping(value = "/api/v1/bills")
public class BillController {

    @Resource
    private BillService billService;

    @ApiOperation(value = "租贷车辆", httpMethod = "POST")
    @ApiImplicitParam(name = "cid", value = "车辆id", required = true, dataType = "Long")
    @PostMapping
    private CommonResult<BillDTO> addBill(@RequestParam Long cid) {
        long uid = getUidFromSubject();
        notNullVerify(cid);
        BillDTO billDTO = billService.addBill(uid, cid);
        return CommonResult.success(billDTO);
    }

    @ApiOperation(value = "结束租贷", httpMethod = "Put")
    @ApiImplicitParam(name = "cid", value = "车辆id", required = true, dataType = "Long")
    @PutMapping
    private CommonResult<BillDTO> updateBill(@RequestParam Long cid) {
        long uid = getUidFromSubject();
        notNullVerify(cid);
        BillDTO billDTO = billService.updateState(uid, cid);
        return CommonResult.success(billDTO);
    }

    @ApiOperation(value = "支付账单", httpMethod = "Put")
    @ApiImplicitParam(name = "billId", value = "账单id", required = true, dataType = "Long")
    @PutMapping("/pay")
    private CommonResult<?> payBill(@RequestParam Long billId) {
        long uid = getUidFromSubject();
        notNullVerify(billId);
        billService.completePayment(billId, uid);
        return CommonResult.success();
    }

    @ApiOperation(value = "获取未完成订单信息", httpMethod = "Get")
    @GetMapping("/unfinished")
    private CommonResult<BillDTO> getUnfinishedBill() {
        long uid = getUidFromSubject();
        BillDTO billDTO = billService.getUnfinishedBill(uid);
        return CommonResult.success(billDTO);
    }
}
