package com.dash.navigation.domain.entity;

import java.io.Serial;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Notice.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "T_NOTICE")
@DynamicUpdate
@DynamicInsert
public class Notice implements ISortEntity<Notice> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "C_ID", length = 32)
    private String id;

    @Column(name = "C_CONTENT", length = 400)
    private String content;

    @Column(name = "DT_ENDTIME")
    private LocalDateTime endTime;

    @Column(name = "N_SORT")
    private Integer sort;
}
