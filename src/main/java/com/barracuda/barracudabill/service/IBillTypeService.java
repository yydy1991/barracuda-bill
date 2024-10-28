package com.barracuda.barracudabill.service;

import java.util.List;
import com.barracuda.barracudabill.domain.BillType;

/**
 * 账单类型Service接口
 * 
 * @author barracuda
 * @date 2024-10-25
 */
public interface IBillTypeService 
{
    /**
     * 查询账单类型
     * 
     * @param id 账单类型主键
     * @return 账单类型
     */
    public BillType selectBillTypeById(String id);

    /**
     * 查询账单类型列表
     * 
     * @param billType 账单类型
     * @return 账单类型集合
     */
    public List<BillType> selectBillTypeList(BillType billType);

    /**
     * 新增账单类型
     * 
     * @param billType 账单类型
     * @return 结果
     */
    public int insertBillType(BillType billType);

    /**
     * 修改账单类型
     * 
     * @param billType 账单类型
     * @return 结果
     */
    public int updateBillType(BillType billType);

    /**
     * 批量删除账单类型
     * 
     * @param ids 需要删除的账单类型主键集合
     * @return 结果
     */
    public int deleteBillTypeByIds(String ids);

    /**
     * 删除账单类型信息
     * 
     * @param id 账单类型主键
     * @return 结果
     */
    public int deleteBillTypeById(String id);
}
