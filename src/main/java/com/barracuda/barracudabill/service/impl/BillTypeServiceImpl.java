package com.barracuda.barracudabill.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barracuda.barracudabill.mapper.BillTypeMapper;
import com.barracuda.barracudabill.domain.BillType;
import com.barracuda.barracudabill.service.IBillTypeService;
import com.barracuda.common.core.text.Convert;

/**
 * 账单类型Service业务层处理
 *
 * @author barracuda
 * @date 2024-10-25
 */
@Service("billType")
public class BillTypeServiceImpl implements IBillTypeService {
    @Autowired
    private BillTypeMapper billTypeMapper;

    /**
     * 查询账单类型
     *
     * @param id 账单类型主键
     * @return 账单类型
     */
    @Override
    public BillType selectBillTypeById(String id) {
        return billTypeMapper.selectBillTypeById(id);
    }

    /**
     * 查询账单类型列表
     *
     * @param billType 账单类型
     * @return 账单类型
     */
    @Override
    public List<BillType> selectBillTypeList(BillType billType) {
        return billTypeMapper.selectBillTypeList(billType);
    }

    /**
     * 新增账单类型
     *
     * @param billType 账单类型
     * @return 结果
     */
    @Override
    public int insertBillType(BillType billType) {
        return billTypeMapper.insertBillType(billType);
    }

    /**
     * 修改账单类型
     *
     * @param billType 账单类型
     * @return 结果
     */
    @Override
    public int updateBillType(BillType billType) {
        return billTypeMapper.updateBillType(billType);
    }

    /**
     * 批量删除账单类型
     *
     * @param ids 需要删除的账单类型主键
     * @return 结果
     */
    @Override
    public int deleteBillTypeByIds(String ids) {
        return billTypeMapper.deleteBillTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除账单类型信息
     *
     * @param id 账单类型主键
     * @return 结果
     */
    @Override
    public int deleteBillTypeById(String id) {
        return billTypeMapper.deleteBillTypeById(id);
    }

    public List<BillType> list() {
        return selectBillTypeList(new BillType());
    }
}
