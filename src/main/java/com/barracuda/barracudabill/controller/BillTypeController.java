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
import com.barracuda.barracudabill.domain.BillType;
import com.barracuda.barracudabill.service.IBillTypeService;
import com.barracuda.common.core.controller.BaseController;
import com.barracuda.common.core.domain.AjaxResult;
import com.barracuda.common.utils.poi.ExcelUtil;
import com.barracuda.common.core.page.TableDataInfo;

/**
 * 账单类型Controller
 *
 * @author barracuda
 * @date 2024-10-25
 */
@Controller
@RequestMapping("/barracudabill/billtype")
public class BillTypeController extends BaseController {
    private String prefix = "barracudabill/billtype";

    @Autowired
    private IBillTypeService billTypeService;

    @RequiresPermissions("barracudabill:billtype:view")
    @GetMapping()
    public String billtype() {
        return prefix + "/billtype";
    }

    /**
     * 查询账单类型列表
     */
    @RequiresPermissions("barracudabill:billtype:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BillType billType) {
        startPage();
        List<BillType> list = billTypeService.selectBillTypeList(billType);
        return getDataTable(list);
    }

    /**
     * 导出账单类型列表
     */
    @RequiresPermissions("barracudabill:billtype:export")
    @Log(title = "账单类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BillType billType) {
        List<BillType> list = billTypeService.selectBillTypeList(billType);
        ExcelUtil<BillType> util = new ExcelUtil<BillType>(BillType.class);
        return util.exportExcel(list, "账单类型数据");
    }

    /**
     * 新增账单类型
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存账单类型
     */
    @RequiresPermissions("barracudabill:billtype:add")
    @Log(title = "账单类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BillType billType) {
        return toAjax(billTypeService.insertBillType(billType));
    }

    /**
     * 修改账单类型
     */
    @RequiresPermissions("barracudabill:billtype:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        BillType billType = billTypeService.selectBillTypeById(id);
        mmap.put("billType", billType);
        return prefix + "/edit";
    }

    /**
     * 修改保存账单类型
     */
    @RequiresPermissions("barracudabill:billtype:edit")
    @Log(title = "账单类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BillType billType) {
        return toAjax(billTypeService.updateBillType(billType));
    }

    /**
     * 删除账单类型
     */
    @RequiresPermissions("barracudabill:billtype:remove")
    @Log(title = "账单类型", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(billTypeService.deleteBillTypeByIds(ids));
    }
}
