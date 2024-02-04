package com.dash.navigation.controller;

import com.dash.navigation.service.SettingService;
import com.dash.navigation.domain.dto.ChangePassword;
import com.dash.navigation.domain.dto.SettingDto;
import com.dash.navigation.domain.entity.Setting;
import com.dash.navigation.service.UserService;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SettingController.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@RestController
@RequestMapping("/api/v1")
public class SettingController {

    @Resource
    private SettingService settingService;

    @Resource
    private UserService userService;

    /**
     * 获取配置
     *
     * @return Setting
     */
    @GetMapping("/setting")
    public ResponseEntity<Setting> get() {
        return ResponseEntity.ok(settingService.get());
    }

    /**
     * 保存配置
     *
     * @param settingDto settingDto
     * @return Void
     */
    @PatchMapping("/setting")
    public ResponseEntity<Void> saveSetting(@RequestBody SettingDto settingDto) {
        settingService.saveSetting(settingDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * changePassword
     *
     * @param changePassword changePassword
     * @return Void
     */
    @PatchMapping("/user/password")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePassword changePassword) {
        userService.changePassword(changePassword);
        return ResponseEntity.noContent().build();
    }

}
