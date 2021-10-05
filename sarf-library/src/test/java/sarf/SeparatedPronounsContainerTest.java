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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeparatedPronounsContainerTest {

    @Test
    void getPronouns() {
       var actual = SeparatedPronounsContainer.getPronouns();
       assertThat(actual).isNotNull();
       assertThat(actual.size()).isEqualTo(13);

       assertThat(actual.get(0)).isEqualTo("أنا");
       assertThat(actual.get(1)).isEqualTo("نحن");
       assertThat(actual.get(2)).isEqualTo("أنتَ");
       assertThat(actual.get(3)).isEqualTo("أنتِ");
       assertThat(actual.get(4)).isEqualTo("أنتما");
       assertThat(actual.get(5)).isEqualTo("أنتم");
       assertThat(actual.get(6)).isEqualTo("أنتنَّ");
       assertThat(actual.get(7)).isEqualTo("هو");
       assertThat(actual.get(8)).isEqualTo("هي");
       assertThat(actual.get(9)).isEqualTo("هما(مذ)");
       assertThat(actual.get(10)).isEqualTo("هما(مؤ)");
       assertThat(actual.get(11)).isEqualTo("هم");
       assertThat(actual.get(12)).isEqualTo("هنَّ");
    }
}