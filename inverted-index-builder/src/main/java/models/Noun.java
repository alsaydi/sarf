package models;/*
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

import java.util.List;

public class Noun {
    private String key;
    private List<String> indefiniteNouns;
    private List<String> definiteNouns;
    private List<String> annexedNouns;
    private List<String> annexedToIndefinite;
    private List<String> annexedToDefinite;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getIndefiniteNouns() {
        return indefiniteNouns;
    }

    public void setIndefiniteNouns(List<String> indefiniteNouns) {
        this.indefiniteNouns = indefiniteNouns;
    }

    public List<String> getDefiniteNouns() {
        return definiteNouns;
    }

    public void setDefiniteNouns(List<String> definiteNouns) {
        this.definiteNouns = definiteNouns;
    }

    public List<String> getAnnexedNouns() {
        return annexedNouns;
    }

    public void setAnnexedNouns(List<String> annexedNouns) {
        this.annexedNouns = annexedNouns;
    }

    public List<String> getAnnexedToIndefinite() {
        return annexedToIndefinite;
    }

    public void setAnnexedToIndefinite(List<String> annexedToIndefinite) {
        this.annexedToIndefinite = annexedToIndefinite;
    }

    public List<String> getAnnexedToDefinite() {
        return annexedToDefinite;
    }

    public void setAnnexedToDefinite(List<String> annexedToDefinite) {
        this.annexedToDefinite = annexedToDefinite;
    }
}
