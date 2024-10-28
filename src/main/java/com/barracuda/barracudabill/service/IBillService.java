package com.barracuda.barracudabill.service;

import java.util.List;
import com.barracuda.barracudabill.domain.Bill;

/**
 * 账单Service接口
 * 
 * @author barracuda
 * @date 2024-10-28
 */
public interface IBillService 
{
    /**
     * 查询账单
     * 
     * @param id 账单主键
     * @return 账单
     */
    public Bill selectBillById(String id);

    /**
     * 查询账单列表
     * 
     * @param bill 账单
     * @return 账单集合
     */
    public List<Bill> selectBillList(Bill bill);

    /**
     * 新增账单
     * 
     * @param bill 账单
     * @return 结果
     */
    public int insertBill(Bill bill);

    /**
     * 修改账单
     * 
     * @param bill 账单
     * @return 结果
     */
    public int updateBill(Bill bill);

    /**
     * 批量删除账单
     * 
     * @param ids 需要删除的账单主键集合
     * @return 结果
     */
    public int deleteBillByIds(String ids);

    /**
     * 删除账单信息
     * 
     * @param id 账单主键
     * @return 结果
     */
    public int deleteBillById(String id);
}
