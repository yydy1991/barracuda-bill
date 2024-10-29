package com.barracuda.barracudabill.domain;

import com.barracuda.common.annotation.Excel;
import com.barracuda.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 账单对象 bi_bill
 *
 * @author barracuda
 * @date 2024-10-28
 */
@Getter
@Setter
public class Bill extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private int delFlag;
    /**
     *
     */
    private String id;

    /**
     * 账单类型
     */
    @Excel(name = "账单类型")
    private String billType;

    /**
     * 金额
     */
    @Excel(name = "金额")
    private Double amount;

    /**
     * 支付时间
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8"
    )
    private Date paymentTime;
}
