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
import org.jetbrains.annotations.NotNull;

public class WordPresenter {
    private final String text;

    private static final WordPresenter empty = new WordPresenter("");
    public static final WordPresenter Empty = empty;
    private WordPresenter(@NotNull String text) {
        this.text = text;
    }


    public static WordPresenter fromText(@NotNull String text){
        return new WordPresenter(text);
    }

    private String present(){
        return this.text;
    }
    public boolean isEmpty() {
        return this.present().equals("");
    }

    public boolean contains(String subString) {
        if (isEmpty())
            return false;

        return this.present().contains(subString);
    }

    public WordPresenter replaceAll(String regex, String replacement) {
        var newText = this.present().replaceAll(regex, replacement);
        return new WordPresenter(newText);
    }

    public boolean endsWith(String segment) {
        if (this.isEmpty()) {
            return false;
        }

        return this.present().endsWith(segment);
    }

    public int lastIndexOf(String segment) {
        if (this.isEmpty()) {
            return -1;
        }
        return this.present().lastIndexOf(segment);
    }

    public WordPresenter substring(int start, int end) {
        if (this.isEmpty()) {
            return WordPresenter.Empty;
        }
        var newText = this.present().substring(start, end);
        return new WordPresenter(newText);
    }

    public WordPresenter append(String suffix) {
        var newText = this.isEmpty() ? "" + suffix : this.present() + suffix;
        return new WordPresenter(newText);
    }

    public boolean startsWith(String segment) {
        if (this.isEmpty()) {
            return false;
        }

        return this.present().startsWith(segment);
    }

    public WordPresenter replaceFirst(String regex, String replacement) {
        if(this.isEmpty()){
            return Empty;
        }

        var newText = this.present().replaceFirst(regex, replacement);
        return new WordPresenter(newText);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof WordPresenter))
            return false;

        var otherWord = (WordPresenter) obj;
        return this.present().equals(otherWord.present());
    }

    @Override
    public String toString(){
        return this.present();
    }
}
