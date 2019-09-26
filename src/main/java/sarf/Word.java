package sarf;

import org.jetbrains.annotations.NotNull;

public class Word {
    private static final Word empty = new Word("");
    public static final Word Empty = empty;

    private final String text;

    protected Word(){
        this.text = "";
    }
    public Word(@NotNull String text) {
        if(null == text){
            throw new IllegalArgumentException("text cannot be null");
        }
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

    public boolean isEmpty() {
        return this.text.equals("");
    }

    public boolean contains(String subString) {
        if (isEmpty())
            return false;

        return this.text.contains(subString);
    }

    public Word replaceAll(String regex, String replacement) {
        var newText = this.text.replaceAll(regex, replacement);
        return new Word(newText);
    }

    public boolean endsWith(String segment) {
        if (this.isEmpty()) {
            return false;
        }

        return this.text.endsWith(segment);
    }

    public int lastIndexOf(String segment) {
        if (this.isEmpty()) {
            return -1;
        }
        return this.text.lastIndexOf(segment);
    }

    public Word substring(int start, int end) {
        if (this.isEmpty()) {
            return Empty;
        }
        var newText = this.text.substring(start, end);
        return new Word(newText);
    }

    public Word append(String suffix) {
        var newText = this.isEmpty() ? "" + suffix : this.text + suffix;
        return new Word(newText);
    }

    public boolean startsWith(String segment) {
        if (this.isEmpty()) {
            return false;
        }

        return this.text.startsWith(segment);
    }

    public Word replaceFirst(String regex, String replacement) {
        if(this.isEmpty()){
            return Word.Empty;
        }

        var newText = this.text.replaceFirst(regex, replacement);
        return new Word(newText);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Word))
            return false;

        var otherWord = (Word) obj;
        return this.text.equals(otherWord.text);
    }

    public static Word fromText(@NotNull String text){
        if(text == null){
            throw new IllegalArgumentException("text cannot be null");
        }
        return new Word(text);
    }
}
