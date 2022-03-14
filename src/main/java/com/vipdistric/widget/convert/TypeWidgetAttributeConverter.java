package com.vipdistric.widget.convert;

import javax.persistence.AttributeConverter;

import com.vipdistric.widget.enums.TypeWidget;

public class TypeWidgetAttributeConverter implements AttributeConverter<TypeWidget, Integer>{

	@Override
	public Integer convertToDatabaseColumn(TypeWidget type) {
		if (type == null)
            return null;
 
        switch (type) {
        case SEARCH:
            return 1;
 
        case HTML_CONTENT:
            return 2;
 
        case IMAGE:
            return 3;
 
        default:
            throw new IllegalArgumentException(type + " not supported.");
        }
	}

	@Override
	public TypeWidget convertToEntityAttribute(Integer dbData) {
		if (dbData == null)
            return null;
 
        switch (dbData) {
        case 1:
            return TypeWidget.SEARCH;
 
        case 2:
            return TypeWidget.HTML_CONTENT;
 
        case 3:
            return TypeWidget.IMAGE;
 
        default:
            throw new IllegalArgumentException(dbData + " not supported.");
        }
	}

}
