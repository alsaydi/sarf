package sarf;
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
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WordPresenterTest {

    @Test
    void testToString() {
        assertThat(WordPresenter.fromText("").toString()).isEqualTo("");
        assertThat(WordPresenter.fromText("ب").toString()).isEqualTo("ب");
    }

    @Test
    void isEmpty() {
        assertThat(WordPresenter.fromText("").isEmpty()).isTrue();
        assertThat(WordPresenter.fromText("و").isEmpty()).isFalse();
    }

    @Test
    void contains() {
        assertThat(WordPresenter.fromText("").contains("f")).isFalse();
        assertThat(WordPresenter.fromText("سمر").contains("f")).isFalse();
        assertThat(WordPresenter.fromText("سمر").contains("مر")).isTrue();
        assertThat(WordPresenter.fromText("سمر").contains("سمر")).isTrue();
        assertThat(WordPresenter.fromText("سمر").contains("")).isTrue();
    }

    @Test
    void replaceAll() {
        var sut = WordPresenter.fromText("test");
        var actual = sut.replaceAll("t", "T");
        assertThat(actual).isEqualTo(WordPresenter.fromText("TesT"));
    }

    @Test
    void endsWith() {
        var sut = WordPresenter.fromText("test");
        assertThat(sut.endsWith("test")).isTrue();
        assertThat(sut.endsWith("")).isTrue();
        assertThat(sut.endsWith("t")).isTrue();
        assertThat(sut.endsWith("d")).isFalse();
    }

    @Test
    void lastIndexOf() {
        var sut = WordPresenter.fromText("test");
        assertThat(sut.lastIndexOf("test")).isEqualTo(0);
        assertThat(sut.lastIndexOf("")).isEqualTo(4);
        assertThat(sut.lastIndexOf("t")).isEqualTo(3);
        assertThat(sut.lastIndexOf("d")).isEqualTo(-1);
    }

    @Test
    void substring() {
        var sut = WordPresenter.fromText("test");
        assertThat(sut.substring(0, 1)).isEqualTo(WordPresenter.fromText("t"));
        assertThat(sut.substring(0, 0)).isEqualTo(WordPresenter.fromText(""));
    }

    @Test
    void append() {
        var sut = WordPresenter.fromText("test");
        assertThat(sut.append(" again")).isEqualTo(WordPresenter.fromText("test again"));
    }
}