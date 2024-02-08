package com.dash.navigation.repository.converter;

import com.alibaba.fastjson.JSON;
import com.dash.navigation.domain.dto.CardIconDto;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * CardIconConverter.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Converter(autoApply = true)
public class CardIconConverter implements AttributeConverter<CardIconDto, String>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String convertToDatabaseColumn(CardIconDto attribute) {
        return JSON.toJSONString(attribute);
    }

    @Override
    public CardIconDto convertToEntityAttribute(String dbData) {
        return JSON.parseObject(dbData, CardIconDto.class);
    }

}
