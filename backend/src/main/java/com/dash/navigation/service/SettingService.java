package com.dash.navigation.service;

import com.dash.navigation.repository.SettingRepository;
import com.dash.navigation.domain.dto.SettingDto;
import com.dash.navigation.domain.entity.Setting;
import com.dash.navigation.common.constants.TeamNavConstants;
import com.dash.navigation.common.util.BeanExtUtils;
import javax.annotation.Resource;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * SettingService.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Service
public class SettingService implements ApplicationRunner {

    @Resource
    private SettingRepository settingRepository;

    private Setting settingCache;

    @Value("${nav-name}")
    private String navName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Setting setting = get();
        if (StringUtils.isBlank(setting.getNavName())) {
            // 加载默认配置，兼容老版本
            setting.setNavName(navName);
            settingRepository.save(setting);
        }
        if (StringUtils.isBlank(setting.getLogoPath())) {
            setting.setLogoPath(TeamNavConstants.DEFAULT_LOGO_PATH);
            settingRepository.save(setting);
        }
        if (StringUtils.isBlank(setting.getLayoutSize())) {
            setting.setLayoutSize("small-layout");
            settingRepository.save(setting);
        }
        this.settingChange(setting);
    }

    /**
     * get
     *
     * @return Setting
     */
    public Setting get() {
        return settingRepository.findAll().stream().findFirst().orElse(new Setting().setId("setting-id"));
    }

    /**
     * save
     *
     * @param settingDto nginx
     */
    public void saveSetting(SettingDto settingDto) {
        Setting setting = BeanExtUtils.convert(settingDto, Setting::new).setId("setting-id");
        setting.setNginxUrl(StringUtils.stripEnd(settingDto.getNginxUrl(), "/"));
        if (StringUtils.isBlank(setting.getLogoPath())) {
            setting.setLogoPath(TeamNavConstants.DEFAULT_LOGO_PATH);
        }
        settingRepository.save(setting);
        this.settingChange(setting);
    }

    /**
     * 获取经过一些处理能直接使用的设置
     *
     * @return Setting
     */
    public Setting getSettingCache() {
        return this.settingCache;
    }

    private void settingChange(Setting setting) {
        this.settingCache = BeanExtUtils.convert(setting, Setting::new);
        this.settingCache.setNginxUrl(BooleanUtils.isTrue(setting.getNginxOpen())
                && StringUtils.isNotBlank(setting.getNginxUrl())
                ? setting.getNginxUrl() : StringUtils.EMPTY);
        settingCache.setNavName(setting.getNavName());
        settingCache.setLogoToFavicon(BooleanUtils.isTrue(setting.getLogoToFavicon()));
        settingCache.setCutOverSpeed((setting.getCutOverSpeed() == null ? 10 : setting.getCutOverSpeed()) * 1000);
        settingCache.setLogoPath(setting.getLogoPath());
    }

}
