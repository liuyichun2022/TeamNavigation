package com.dash.navigation.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;

/**
 * 导航分类.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "T_CATEGORY")
@DynamicUpdate
@DynamicInsert
public class Category implements ISortEntity<Category> {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "C_ID", length = 32)
    private String id;

    /**
     * 图标
     */
    @Column(name = "C_ICON", length = 400)
    private String icon;

    /**
     * 分类名称
     */
    @Column(name = "C_NAME", length = 100)
    private String name;

    /**
     * 是否是私密分类
     */
    @Column(name = "N_PRIVATE_CARD")
    private Boolean privateCard;

    /**
     * 是否有效
     */
    @Column(name = "N_VALID")
    private Boolean valid;

    /**
     * 序号
     */
    @Column(name = "N_SORT")
    private Integer sort;

}
