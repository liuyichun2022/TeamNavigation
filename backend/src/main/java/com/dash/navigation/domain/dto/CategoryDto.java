package com.dash.navigation.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * Category.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
@Accessors(chain = true)
public class CategoryDto  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String icon;

    private String name;

    private Boolean privateCard;

    private Boolean valid;

    private Integer sort;

}
