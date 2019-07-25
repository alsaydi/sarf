package sarf.util;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import sarf.KindOfVerb;

import java.util.Arrays;

public final class KindOfVerbConverter  implements Converter {

    @Override
    public Object convert(Class type, Object value) {
        if(value == null){
            throw new ConversionException("value cannot be null");
        }

        if(value instanceof KindOfVerb)
            return value;

        var str = value.toString();
        var ordinalValue = Integer.parseInt(str);
        var allOrdinalValues = KindOfVerb.values();
        var enumValue = Arrays.stream(allOrdinalValues).filter(k -> k.getValue() == ordinalValue)
                .findFirst();
        return enumValue.orElseGet(enumValue::orElseThrow);
    }
}
