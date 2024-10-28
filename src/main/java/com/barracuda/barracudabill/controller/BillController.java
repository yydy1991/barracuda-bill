package com.barracuda.barracudabill.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.barracuda.common.annotation.Log;
import com.barracuda.common.enums.BusinessType;
import com.barracuda.barracudabill.domain.Bill;
import com.barracuda.barracudabill.service.IBillService;
import com.barracuda.common.core.controller.BaseController;
import com.barracuda.common.core.domain.AjaxResult;
import com.barracuda.common.utils.poi.ExcelUtil;
import com.barracuda.common.core.page.TableDataInfo;

/**
 * 账单Controller
 *
 * @author barracuda
 * @date 2024-10-28
 */
@Controller
@RequestMapping("/barracudabill/bill")
public class BillController extends BaseController {
    private String prefix = "barracudabill/bill";

    @Autowired
    private IBillService billService;

    @RequiresPermissions("barracudabill:bill:view")
    @GetMapping()
    public String bill() {
        return prefix + "/bill";
    }

    /**
     * 查询账单列表
     */
    @RequiresPermissions("barracudabill:bill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Bill bill) {
        startPage();
        List<Bill> list = billService.selectBillList(bill);
        return getDataTable(list);
    }

    /**
     * 导出账单列表
     */
    @RequiresPermissions("barracudabill:bill:export")
    @Log(title = "账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Bill bill) {
        List<Bill> list = billService.selectBillList(bill);
        ExcelUtil<Bill> util = new ExcelUtil<Bill>(Bill.class);
        return util.exportExcel(list, "账单数据");
    }

    /**
     * 新增账单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存账单
     */
    @RequiresPermissions("barracudabill:bill:add")
    @Log(title = "账单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Bill bill) {
        return toAjax(billService.insertBill(bill));
    }

    /**
     * 修改账单
     */
    @RequiresPermissions("barracudabill:bill:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Bill bill = billService.selectBillById(id);
        mmap.put("bill", bill);
        return prefix + "/edit";
    }

    /**
     * 修改保存账单
     */
    @RequiresPermissions("barracudabill:bill:edit")
    @Log(title = "账单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Bill bill) {
        return toAjax(billService.updateBill(bill));
    }

    /**
     * 删除账单
     */
    @RequiresPermissions("barracudabill:bill:remove")
    @Log(title = "账单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(billService.deleteBillByIds(ids));
    }
}
