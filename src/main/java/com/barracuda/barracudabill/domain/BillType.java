package com.barracuda.barracudabill.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.barracuda.common.annotation.Excel;
import com.barracuda.common.core.domain.BaseEntity;

/**
 * 账单类型对象 bi_bill_type
 *
 * @author barracuda
 * @date 2024-10-25
 */
@Getter
@Setter
public class BillType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 编码
     */
    @Excel(name = "编码")
    private String code;

}
