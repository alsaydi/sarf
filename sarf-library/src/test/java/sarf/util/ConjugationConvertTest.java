package sarf.util;


import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.beanutils.ConversionException;
import org.junit.jupiter.api.Test;
import sarf.Conjugation;

class ConjugationConvertTest {

    @Test
    void Test_Convert(){
        var sut = new ConjugationConverter();

        assertEquals(Conjugation.First,sut.convert(Conjugation.class, "1"));
        assertEquals(Conjugation.Second,sut.convert(Conjugation.class, "2"));
        assertEquals(Conjugation.Third,sut.convert(Conjugation.class, "3"));
        assertEquals(Conjugation.Forth,sut.convert(Conjugation.class, "4"));
        assertEquals(Conjugation.Fifth,sut.convert(Conjugation.class, "5"));
        assertEquals(Conjugation.Sixth,sut.convert(Conjugation.class, "6"));
    }

    @Test()
    void InvalidValue_Convert_ThrowsException(){
        var sut = new ConjugationConverter();
        assertThrows(ConversionException.class, () -> sut.convert(Conjugation.class, "test"));
    }

    @Test()
    void EmptyValue_Convert_ThrowsException(){
        var sut = new ConjugationConverter();
        assertThrows(ConversionException.class, () -> sut.convert(Conjugation.class, ""));
    }

    @Test()
    void NullValue_Convert_ThrowsException(){
        var sut = new ConjugationConverter();
        assertThrows(ConversionException.class, () -> sut.convert(Conjugation.class, null));
    }
}
