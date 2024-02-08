package com.dash.navigation.domain.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * CardZipDto.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
@Accessors(chain = true)
public class CardZipDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String path;

}
