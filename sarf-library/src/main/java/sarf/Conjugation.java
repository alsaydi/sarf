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
/**
 * It's one of the six bab of tasreef
 * أحد أبواب التصريف الستة
 * الأول - فعَل -- يفعٌل (بفتح عين الماضي و بضـم عين المضارع)
 * الثاني - فعَل -- يفعِل (بفتح عين الماضي و بكسر عين المضارع)
 * الثالث - فعَل -- يفعَل (بفتح عين الماضي و بفتح عين المضارع)
 *
 * الرابع - فعٍل -- يفعَل (بكسر عين الماضي و فتح عين المضارع)
 * الخامس - فعٌل -- يفعٌل (بضـم عين الماضي و ضـم عين المضارع)
 * السادس - فعٍل -- يفعِل (بكسر عين الماضي و كسر عين المضارع)
 */
public enum  Conjugation {
    First(1),
    Second(2),
    Third(3),
    Forth(4),
    Fifth(5),
    Sixth(6);

    private final int value;
    Conjugation(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
