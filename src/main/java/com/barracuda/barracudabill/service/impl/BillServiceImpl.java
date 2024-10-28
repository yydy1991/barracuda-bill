package com.barracuda.barracudabill.service.impl;

import java.util.List;

import com.barracuda.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barracuda.barracudabill.mapper.BillMapper;
import com.barracuda.barracudabill.domain.Bill;
import com.barracuda.barracudabill.service.IBillService;
import com.barracuda.common.core.text.Convert;

/**
 * 账单Service业务层处理
 *
 * @author barracuda
 * @date 2024-10-28
 */
@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    private BillMapper billMapper;

    /**
     * 查询账单
     *
     * @param id 账单主键
     * @return 账单
     */
    @Override
    public Bill selectBillById(String id) {
        return billMapper.selectBillById(id);
    }

    /**
     * 查询账单列表
     *
     * @param bill 账单
     * @return 账单
     */
    @Override
    public List<Bill> selectBillList(Bill bill) {
        return billMapper.selectBillList(bill);
    }

    /**
     * 新增账单
     *
     * @param bill 账单
     * @return 结果
     */
    @Override
    public int insertBill(Bill bill) {
        bill.setCreateTime(DateUtils.getNowDate());
        return billMapper.insertBill(bill);
    }

    /**
     * 修改账单
     *
     * @param bill 账单
     * @return 结果
     */
    @Override
    public int updateBill(Bill bill) {
        bill.setUpdateTime(DateUtils.getNowDate());
        return billMapper.updateBill(bill);
    }

    /**
     * 批量删除账单
     *
     * @param ids 需要删除的账单主键
     * @return 结果
     */
    @Override
    public int deleteBillByIds(String ids) {
        return billMapper.deleteBillByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除账单信息
     *
     * @param id 账单主键
     * @return 结果
     */
    @Override
    public int deleteBillById(String id) {
        return billMapper.deleteBillById(id);
    }
}
