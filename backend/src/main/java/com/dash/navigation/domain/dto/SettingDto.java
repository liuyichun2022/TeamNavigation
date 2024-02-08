package com.dash.navigation.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * NginxDTO.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
public class SettingDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Boolean nginxOpen;

    private String nginxUrl;

    private String navName;

    private String logoPath;

    private Integer cutOverSpeed;

    private Boolean logoToFavicon;

    private String layoutSize;

}
