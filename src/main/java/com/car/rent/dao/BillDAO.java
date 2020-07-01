package com.car.rent.dao;

import com.car.rent.entity.Bill;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nayix
 * @date 2020/6/30 16:19
 */
public interface BillDAO extends CrudRepository<Bill, Long> {
    /**
     * 获取最近一笔未完成订单
     * @param uid
     * @return
     */
    @Query("select b from Bill b where b.user.uid = :uid and b.billState <> 'Paid'")
    Bill getRecentBill(long uid);

    /**
     * 更新订单状态为已支付
     * @param billId
     * @return
     */
    @Modifying
    @Transactional
    @Query("update Bill set billState = 'Paid' where billId = :billId")
    int updateStateToPaid(long billId);
}
