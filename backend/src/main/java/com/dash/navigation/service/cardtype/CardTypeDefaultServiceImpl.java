package com.dash.navigation.service.cardtype;

import com.dash.navigation.common.annotation.CardType;
import com.dash.navigation.common.enums.CardTypeEnum;
import com.dash.navigation.domain.dto.CardIconDto;
import com.dash.navigation.domain.entity.Card;
import com.dash.navigation.domain.vo.CardTreeChildVo;
import com.dash.navigation.common.util.FileExtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * CardTypeDefaultServiceImpl.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Service
@CardType({CardTypeEnum.DEFAULT, CardTypeEnum.QRCODE})
public class CardTypeDefaultServiceImpl implements ICardTypeService {

    @Override
    public void formatCardVo(CardTreeChildVo cardVo) {
        // 默认的不用实现
    }

    @Override
    public void supplySave(String id, Card card) {
        // 默认的不用实现
    }

    @Override
    public void supplyDelete(Card card) {
        CardIconDto cardIconDto = card.getIcon();
        if (StringUtils.isNotBlank(cardIconDto.getSrc())
                && !StringUtils.contains(cardIconDto.getSrc(), "default")) {
            FileExtUtils.deleteFiles(false, cardIconDto.getSrc());
        }
    }

}
