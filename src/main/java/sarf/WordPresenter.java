package sarf;

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
