package com.dash.navigation.domain.entity;

import com.dash.navigation.domain.dto.CardZipDto;
import com.dash.navigation.domain.dto.CardIconDto;

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
 * Card.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "T_CARD")
@DynamicInsert
@DynamicUpdate
public class Card implements ISortEntity<Card> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "C_ID", length = 32)
    private String id;

    @Column(name = "C_TYPE", length = 100)
    private String type;

    @Column(name = "C_CATEGORY", length = 32)
    private String category;

    @Column(name = "C_ICON", length = 400)
    private CardIconDto icon;

    @Column(name = "C_TITLE", length = 200)
    private String title;

    @Column(name = "C_CONTENT", length = 400)
    private String content;

    @Column(name = "C_URL", length = 200)
    private String url;

    @Column(name = "C_ZIP", length = 400)
    private CardZipDto zip;

    @Column(name = "N_SORT")
    private Integer sort;
}
