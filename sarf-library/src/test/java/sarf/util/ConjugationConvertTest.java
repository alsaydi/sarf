package sarf.util;
/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
