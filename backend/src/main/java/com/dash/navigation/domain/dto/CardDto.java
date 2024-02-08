package com.dash.navigation.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * CardDto.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
public class CardDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 判断是原型还是普通
     */
    private String type;

    /**
     * 分类ID
     */
    private String category;

    /**
     * 结构化数据的icon
     */
    private CardIconDto icon;

    private String title;

    private String content;

    private String url;

    private CardZipDto zip;

    private Integer sort;

}
