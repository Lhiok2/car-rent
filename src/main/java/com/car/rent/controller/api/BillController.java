package com.car.rent.controller.api;

import com.car.rent.vo.BillVO;
import com.car.rent.vo.CommonResult;
import com.car.rent.service.BillService;
import io.swagger.annotations.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

import static com.car.rent.utils.PageUtils.getPageable;
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

    @ApiOperation(value = "获取账单列表", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页尺寸", dataType = "Integer")
    })
    @GetMapping("/list")
    private CommonResult<List<BillVO>> getBillList(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        long uid = getUidFromSubject();
        Pageable pageable = getPageable(pageIndex, pageSize);
        List<BillVO> billList = billService.getBillList(uid, pageable);
        return CommonResult.success(billList);
    }

    @ApiOperation(value = "租贷车辆", httpMethod = "POST")
    @ApiImplicitParam(name = "cid", value = "车辆id", required = true, dataType = "Long")
    @PostMapping
    private CommonResult<BillVO> addBill(@RequestParam Long cid) {
        long uid = getUidFromSubject();
        notNullVerify(cid);
        BillVO billVO = billService.addBill(uid, cid);
        return CommonResult.success(billVO);
    }

    @ApiOperation(value = "结束租贷", httpMethod = "PUT")
    @ApiImplicitParam(name = "billId", value = "账单id", required = true, dataType = "Long")
    @PutMapping
    private CommonResult<?> updateBill(@RequestParam Long billId) {
        long uid = getUidFromSubject();
        notNullVerify(billId);
        billService.updateState(billId, uid);
        return CommonResult.success();
    }

    @ApiOperation(value = "支付账单", httpMethod = "PUT")
    @ApiImplicitParam(name = "billId", value = "账单id", required = true, dataType = "Long")
    @PutMapping("/pay")
    private CommonResult<?> payBill(@RequestParam Long billId) {
        long uid = getUidFromSubject();
        notNullVerify(billId);
        billService.completePayment(billId, uid);
        return CommonResult.success();
    }

    @ApiOperation(value = "获取未完成订单信息", httpMethod = "GET")
    @GetMapping("/unfinished")
    private CommonResult<BillVO> getUnfinishedBill() {
        long uid = getUidFromSubject();
        BillVO billVO = billService.getUnfinishedBill(uid);
        return CommonResult.success(billVO);
    }
}
