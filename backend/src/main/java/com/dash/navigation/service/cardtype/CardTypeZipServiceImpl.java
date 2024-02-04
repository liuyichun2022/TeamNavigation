package com.dash.navigation.service.cardtype;

import com.dash.navigation.common.annotation.CardType;
import com.dash.navigation.common.enums.CardTypeEnum;
import com.dash.navigation.repository.CardRepository;
import com.dash.navigation.service.SettingService;
import com.dash.navigation.domain.dto.CardIconDto;
import com.dash.navigation.domain.dto.CardZipDto;
import com.dash.navigation.domain.entity.Card;
import com.dash.navigation.domain.entity.Setting;
import com.dash.navigation.domain.vo.CardTreeChildVo;
import com.dash.navigation.common.util.FileExtUtils;
import com.dash.navigation.common.util.StringExtUtils;
import com.dash.navigation.common.util.ZipUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * CardTypeZipService.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Service
@CardType(CardTypeEnum.ZIP)
public class CardTypeZipServiceImpl implements ICardTypeService {

    @Resource
    private SettingService settingService;

    @Resource
    private CardRepository cardRepository;

    @Override
    public void formatCardVo(CardTreeChildVo cardVo) {
        Setting settingCache = settingService.getSettingCache();
        if (StringUtils.isNotBlank(settingCache.getNginxUrl())) {
            cardVo.setUrl(settingCache.getNginxUrl() + cardVo.getUrl());
        }
    }

    @Override
    public void supplySave(String id, Card card) {
        if (StringUtils.isNotBlank(id)) {
            String existPath = cardRepository.findById(id).map(Card::getZip)
                    .map(CardZipDto::getPath)
                    .orElse(StringUtils.EMPTY);
            String curPath = Optional.of(card).map(Card::getZip)
                    .map(CardZipDto::getPath)
                    .orElse(StringUtils.EMPTY);
            if (Objects.equals(existPath, curPath)) {
                // 没有上传新的压缩包就不重新解压了
                return;
            }
        }
        FileExtUtils.deleteFiles(true, "/ext-resources/modules/" + card.getId());
        ZipUtils.unzip(card.getId(), card.getZip().getPath());
        card.setUrl(StringExtUtils.format("/ext-resources/modules/{}/index.html", card.getId()));
    }

    @Override
    public void supplyDelete(Card card) {
        CardIconDto cardIconDto = card.getIcon();
        List<String> deletePaths = new ArrayList<>();
        if (StringUtils.isNotBlank(cardIconDto.getSrc())
                && !StringUtils.contains(cardIconDto.getSrc(), "default")) {
            deletePaths.add(cardIconDto.getSrc());
        }
        deletePaths.add(card.getZip().getPath());
        deletePaths.add("/ext-resources/modules/" + card.getId());
        FileExtUtils.deleteFiles(false, deletePaths.toArray(new String[0]));
    }

}
