package com.dash.navigation.domain.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * CardIconDto.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
@Accessors(chain = true)
public class CardIconDto implements Serializable {

    private static final long serialVersionUID = -3967231783015153342L;

    private String src;

    private String text;

    private String color;
}
