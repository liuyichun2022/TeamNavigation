package com.dash.navigation.repository.converter;

import com.alibaba.fastjson.JSON;
import com.dash.navigation.domain.dto.CardZipDto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.Serial;
import java.io.Serializable;

/**
 * CardZipConverter.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Converter(autoApply = true)
public class CardZipConverter implements AttributeConverter<CardZipDto, String>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String convertToDatabaseColumn(CardZipDto attribute) {
        return JSON.toJSONString(attribute);
    }

    @Override
    public CardZipDto convertToEntityAttribute(String dbData) {
        return JSON.parseObject(dbData, CardZipDto.class);
    }

}
