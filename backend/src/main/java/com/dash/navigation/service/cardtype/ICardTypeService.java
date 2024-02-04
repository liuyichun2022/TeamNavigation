package com.dash.navigation.service.cardtype;

import com.dash.navigation.domain.entity.Card;
import com.dash.navigation.domain.vo.CardTreeChildVo;

/**
 * 类型接口，方便扩展.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
public interface ICardTypeService {

    /**
     * formatCard
     *
     * @param cardVo cardVo
     */
    void formatCardVo(CardTreeChildVo cardVo);

    /**
     * supplySave
     *
     * @param id id
     * @param card card
     */
    void supplySave(String id, Card card);

    /**
     * supplyDelete
     *
     * @param card card
     */
    void supplyDelete(Card card);

}
