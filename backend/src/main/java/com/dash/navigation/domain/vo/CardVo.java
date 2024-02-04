package com.dash.navigation.domain.vo;

import com.dash.navigation.domain.dto.CardIconDto;
import com.dash.navigation.domain.dto.CardZipDto;
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
public class CardVo {

    private String id;

    private String type;

    private String category;

    private String categoryName;

    private CardIconDto icon;

    private String title;

    private String content;

    private String url;

    private CardZipDto zip;

    private Integer sort;
}
