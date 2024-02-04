package com.dash.navigation.controller;

import com.dash.navigation.service.SettingService;
import com.dash.navigation.domain.entity.Setting;
import com.dash.navigation.common.util.RequestUtils;
import com.dash.navigation.common.util.SecurityUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Controller
public class ViewController {

    @Resource
    private SettingService settingService;

    @Value("${change-password.enable}")
    private Boolean changePwdEnable;

    @Value("${project.version}")
    private String projectVersion;

    /**
     * 首页访问
     *
     * @param request request
     * @return String
     */
    @GetMapping({"/", "index.html"})
    public String index(HttpServletRequest request) {
        Setting settingCache = settingService.getSettingCache();
        request.setAttribute("navName", settingCache.getNavName());
        request.setAttribute("logoToFavicon", settingCache.getLogoToFavicon());
        request.setAttribute("logoPath", settingCache.getLogoPath());
        request.setAttribute("isIe", RequestUtils.isIe());
        request.setAttribute("cutOverSpeed", settingCache.getCutOverSpeed());
        request.setAttribute("layoutSize", settingCache.getLayoutSize());
        return "index";
    }

    /**
     * login
     *
     * @return String
     */
    @GetMapping("/login")
    public String login() {
        HttpServletRequest request = RequestUtils.getRequest();
        Object error = request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if (error instanceof Exception) {
            request.setAttribute("errorMsg", ((Exception) error).getMessage());
            // 只使用一次就移除，再刷新页面就不显示了
            request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
        request.setAttribute("isIe", RequestUtils.isIe());
        return "login";
    }

    /**
     * 后端管理页面
     *
     * @param request request
     * @return String
     */
    @GetMapping("/admin/**")
    public String admin(HttpServletRequest request) {
        Setting settingCache = settingService.getSettingCache();
        request.setAttribute("page", StringUtils.substringAfterLast(request.getServletPath(), "/"));
        request.setAttribute("navName", settingCache.getNavName());
        request.setAttribute("logoToFavicon", settingCache.getLogoToFavicon());
        request.setAttribute("logoPath", settingCache.getLogoPath());
        request.setAttribute("userInfo", SecurityUtils.getUserInfo());
        request.setAttribute("loginEnable", SecurityUtils.isLoginEnable());
        request.setAttribute("changePwdEnable", changePwdEnable);
        request.setAttribute("projectVersion", projectVersion);
        request.setAttribute("isIe", RequestUtils.isIe());
        return "admin";
    }

}
