package com.dash.navigation.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * NginxDTO.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
public class SettingDto {

    private Boolean nginxOpen;

    private String nginxUrl;

    private String navName;

    private String logoPath;

    private Integer cutOverSpeed;

    private Boolean logoToFavicon;

    private String layoutSize;

}
