package com.barracuda.barracudabill.tool;

import com.barracuda.common.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserTool {
    private UserTool() {

    }

    /**
     * 获取当前用户的登录名 示例：result = "admin";
     *
     * @return 当前用户的登录名
     */
    public static String getCurrentUserLoginName() {
        String result = "";
        try {
            result = ShiroUtils.getLoginName();
        } catch (Exception e) {
            log.error("Error getting login name,e:" + e.getMessage(), e);
        }
        return result;
    }
}
