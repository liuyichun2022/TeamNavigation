package com.dash.navigation.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * NoticeVo.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
@Accessors(chain = true)
public class NoticeVo {

    private String id;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    private Boolean status;

    private Integer sort;

    /**
     * getStatus
     *
     * @return Boolean
     */
    public Boolean getStatus() {
        return Objects.nonNull(endTime) && endTime.isAfter(LocalDateTime.now());
    }

}
