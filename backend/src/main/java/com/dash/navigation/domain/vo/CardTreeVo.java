package com.dash.navigation.domain.vo;

import java.util.List;
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
public class CardTreeVo {

    private String id;

    private String icon;

    private String name;

    private Integer sort;

    private List<CardTreeChildVo> children;
}
