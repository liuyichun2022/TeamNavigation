package com.dash.navigation.domain.vo;

import com.dash.navigation.domain.dto.CardIconDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Card.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
@Accessors(chain = true)
public class CardTreeChildVo {

    private String id;

    private String type;

    private CardIconDto icon;

    private String title;

    private String content;

    private String url;

    private String tip;

    private Integer sort;
}
