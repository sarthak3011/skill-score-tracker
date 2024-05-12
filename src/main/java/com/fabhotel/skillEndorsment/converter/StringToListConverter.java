package com.fabhotel.skillEndorsment.converter;

/**
 @author: Sarthak Gupta
 @description: Converter class to convert list of objects into string using semicolon(;) separator
 @Date: 12th May 2024
 */

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import static com.fabhotel.skillEndorsment.constant.ApplicationConstant.SEMICOLON;
import static java.util.Collections.emptyList;

@Converter
public class StringToListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return CollectionUtils.isNotEmpty(stringList) ? String.join(SEMICOLON, stringList) : null;
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        return StringUtils.isNotEmpty(string) ? Arrays.asList(string.split(SEMICOLON)) : emptyList();
    }
}
