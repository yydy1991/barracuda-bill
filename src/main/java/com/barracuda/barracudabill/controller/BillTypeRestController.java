package com.barracuda.barracudabill.controller;

import com.barracuda.barracudabill.domain.BillType;
import com.barracuda.barracudabill.service.IBillTypeService;
import com.barracuda.common.core.controller.BaseController;
import com.barracuda.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/barracudabill/billtype/rest")
public class BillTypeRestController extends BaseController {
    @Resource
    private IBillTypeService billTypeService;

    @GetMapping("/list")
    public AjaxResult list() {
        List<BillType> billTypes = billTypeService.selectBillTypeList(new BillType());
        return AjaxResult.success(billTypes);
    }
}
