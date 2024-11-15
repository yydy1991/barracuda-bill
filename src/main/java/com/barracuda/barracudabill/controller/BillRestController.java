package com.barracuda.barracudabill.controller;

import com.barracuda.barracudabill.domain.Bill;
import com.barracuda.barracudabill.domain.BillType;
import com.barracuda.barracudabill.service.IBillService;
import com.barracuda.barracudabill.service.IBillTypeService;
import com.barracuda.barracudabill.tool.UserTool;
import com.barracuda.common.annotation.Log;
import com.barracuda.common.core.controller.BaseController;
import com.barracuda.common.core.domain.AjaxResult;
import com.barracuda.common.core.page.TableDataInfo;
import com.barracuda.common.enums.BusinessType;
import com.barracuda.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账单Controller
 *
 * @author barracuda
 * @date 2024-10-28
 */
@RestController
@RequestMapping("/barracudabill/bill/rest")
public class BillRestController extends BaseController {
    @Resource
    private IBillService billService;

    @GetMapping("/listBillByYearAndMonth")
    public AjaxResult listBillByYearAndMonth(Integer year, Integer month) {
        String currentUserLoginName = UserTool.getCurrentUserLoginName();
        List<Bill> bills = billService.listBill(currentUserLoginName, year, month);
        return AjaxResult.success(bills);
    }
}
