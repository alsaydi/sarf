package sarf.util;


import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.ConversionException;
import sarf.Conjugation;

import static sarf.Conjugation.*;

public final class ConjugationConverter implements Converter  {

    @Override
    public Object convert(Class type, Object value) {
        if(value == null){
            throw new ConversionException("value cannot be null");
        }

        if(value instanceof Conjugation)
            return value;

        var str = value.toString();

        switch (str){
            case "1":
                return First;
            case "2":
                return  Second;
            case "3":
                return Third;
            case "4":
                return Forth;
            case "5":
                return Fifth;
            case "6":
                return Sixth;
        }

        throw new ConversionException(str + " is not a valid conjugation -- invalid bab of tasreef");
    }
}
