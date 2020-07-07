package com.car.rent.repository;

import com.car.rent.domain.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nayix
 * @date 2020/6/30 16:19
 */
public interface BillRepository extends CrudRepository<Bill, Long> {

    /**
     * 获取账单列表
     * @param uid
     * @param pageable
     * @return
     */
    @Query("select b from Bill b where b.user.uid = :uid order by b.startTime desc")
    Page<Bill> findAllByUid(long uid, Pageable pageable);

    /**
     * 通过billId查询账单
     * @param billId
     * @return
     */
    Bill findByBillId(long billId);

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
