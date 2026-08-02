package com.sumitdev.SpringHibernate.model;


import jakarta.persistence.AttributeConverter;

public class BooleanToStringConvertor implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {

        if (attribute == null) return null;

        return attribute ? "Yes" : "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {

        if (dbData == null) return null;

        return "Yes".equals(dbData);
    }
}
